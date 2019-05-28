package org.foi.nwtis.mtensic.ejb.sb;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.foi.nwtis.mtensic.ejb.eb.Airplanes;
import org.foi.nwtis.mtensic.ejb.eb.Flights;
import org.foi.nwtis.mtensic.ejb.eb.Myairports;
import org.foi.nwtis.mtensic.ejb.eb.Passangers;
import org.foi.nwtis.mtensic.podaci.PodaciLeta;
import org.foi.nwtis.rest.klijenti.OSKlijent;
import org.foi.nwtis.rest.podaci.AvionLeti;

/**
 *
 * @author Monika
 */
@Stateless
@LocalBean
public class UpravljanjePutnicima {

    private String osUsername = "mtensic";
    private String osPassword = "banana01111";

    @EJB
    private PassangersFacade passangersFacade;

    @EJB
    private MyairportsFacade myAirportsFacade;

    @EJB
    private AirplanesFacade airplanesFacade;

    @EJB
    private FlightsFacade flightsFacade;

    public List<Passangers> dajSvePutnike() {
        return passangersFacade.findAll();
    }

    public List<Myairports> dajSveAerodrome() {
        return myAirportsFacade.findAll();
    }

    public List<PodaciLeta> preuzmiLetoveBazePodataka(String icao, int odVremena, int doVremena) {
        return airplanesFacade.preuzmiLetove(icao, odVremena, doVremena);
    }

    public List<PodaciLeta> preuzmiLetoveOpenSky(String icao, int odVremena, int doVremena) {
        OSKlijent osk = new OSKlijent(osUsername, osPassword);

        List<AvionLeti> letovi = osk.getFlights(icao, odVremena, doVremena);
        Airplanes airplane = null;
        for (AvionLeti let : letovi) {
            airplane = new Airplanes();
            airplane.setIcao24(let.getIcao24());
            airplane.setFirstseen(let.getFirstSeen());
            airplane.setEstdepartureairport(let.getEstDepartureAirport());
            airplane.setLastseen(let.getLastSeen());
            airplane.setEstarrivalairport(let.getEstArrivalAirport());
            airplane.setEstdepartureairporthorizdistance(let.getEstDepartureAirportHorizDistance());
            airplane.setEstdepartureairportvertdistance(let.getEstDepartureAirportVertDistance());
            airplane.setEstarrivalairporthorizdistance(let.getEstArrivalAirportHorizDistance());
            airplane.setEstarrivalairportvertdistance(let.getEstArrivalAirportVertDistance());
            airplane.setCallsign(let.getCallsign());
            airplane.setArrivalairportcandidatescount(let.getArrivalAirportCandidatesCount());
            airplane.setDepartureairportcandidatescount(let.getDepartureAirportCandidatesCount());
            airplanesFacade.create(airplane);
        }

        return airplanesFacade.preuzmiLetove(icao, odVremena, doVremena);
    }

    public boolean dodajLet(int putnikId, int avionId) {
        boolean preklapanje = flightsFacade.provjeriPreklapanjeLetova(0, 0, 0);
        if (!preklapanje) {
            Flights let = new Flights(avionId);
            flightsFacade.create(let);
            return true;
        }
        return false;
    }
    
    public boolean brisiLet(int letId) {
        Flights let = flightsFacade.find(letId);
        if (let == null) {
            return false;
        }
        
        flightsFacade.remove(let);
        return true;
    }
    
    public List<PodaciLeta> preuzmiLetovePutnika(int putnikId, int odVremena, int doVremena) {
        return flightsFacade.preuzmiLetovePutnika(putnikId, odVremena, doVremena);
    }
}
