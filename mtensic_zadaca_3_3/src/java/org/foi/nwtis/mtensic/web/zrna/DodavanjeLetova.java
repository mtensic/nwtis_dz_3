package org.foi.nwtis.mtensic.web.zrna;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.foi.nwtis.mtensic.ejb.eb.Myairports;
import org.foi.nwtis.mtensic.ejb.eb.Passangers;
import org.foi.nwtis.mtensic.ejb.sb.UpravljanjePutnicima;
import org.foi.nwtis.mtensic.podaci.Aerodrom;
import org.foi.nwtis.mtensic.podaci.PodaciLeta;
import org.foi.nwtis.mtensic.podaci.PodaciPutnika;
import org.foi.nwtis.mtensic.web.ws.InformatorPutnika;
import org.foi.nwtis.rest.podaci.Lokacija;

/**
 *
 * @author Monika
 */
@Named(value = "dodavanjeLetova")
@SessionScoped
public class DodavanjeLetova implements Serializable {

    @EJB
    private UpravljanjePutnicima upravljanjePutnicima;

    private String odVremena;
    private String doVremena;
    private ArrayList<PodaciPutnika> putnici = new ArrayList<PodaciPutnika>();
    private int odabraniPutnik;
    private ArrayList<Aerodrom> aerodromi = new ArrayList<Aerodrom>();
    private String odabraniAerodrom;
    private List<PodaciLeta> letovi = new ArrayList<PodaciLeta>();
    private int odabraniLet;
    private boolean preuzetiPodatke;
    private String obavijest = "";

    public DodavanjeLetova() {
    }

    public String getOdVremena() {
        return odVremena;
    }

    public void setOdVremena(String odVremena) {
        this.odVremena = odVremena;
    }

    public String getDoVremena() {
        return doVremena;
    }

    public void setDoVremena(String doVremena) {
        this.doVremena = doVremena;
    }

    public int getOdabraniPutnik() {
        return odabraniPutnik;
    }

    public void setOdabraniPutnik(int odabraniPutnik) {
        this.odabraniPutnik = odabraniPutnik;
    }

    public String getOdabraniAerodrom() {
        return odabraniAerodrom;
    }

    public void setOdabraniAerodrom(String odabraniAerodrom) {
        this.odabraniAerodrom = odabraniAerodrom;
    }

    public int getOdabraniLet() {
        return odabraniLet;
    }

    public void setOdabraniLet(int odabraniLet) {
        this.odabraniLet = odabraniLet;
    }

    public boolean isPreuzetiPodatke() {
        return preuzetiPodatke;
    }

    public void setPreuzetiPodatke(boolean preuzetiPodatke) {
        this.preuzetiPodatke = preuzetiPodatke;
    }

    public ArrayList<Aerodrom> getAerodromi() {
        List<Myairports> aerodromiEntitet = upravljanjePutnicima.dajSveAerodrome();
        aerodromi.clear();
        for (Myairports aerodromEntitet : aerodromiEntitet) {
            Aerodrom aerodrom = new Aerodrom();
            aerodrom.setDrzava(aerodromEntitet.getIsoCountry());
            aerodrom.setIcao(aerodromEntitet.getIdent());
            aerodrom.setNaziv(aerodromEntitet.getName());
            String[] koordinate = aerodromEntitet.getCoordinates().split(",");
            aerodrom.setLokacija(new Lokacija(koordinate[0], koordinate[1]));
            aerodromi.add(aerodrom);
        }
        return aerodromi;
    }

    public List<PodaciLeta> getLetovi() {
        return letovi;
    }

    public ArrayList<PodaciPutnika> getPutnici() {
        List<Passangers> putniciEntitet = upravljanjePutnicima.dajSvePutnike();
        putnici.clear();
        for (Passangers putnikEntitet : putniciEntitet) {
            PodaciPutnika putnik = new PodaciPutnika();
            putnik.setFirstname(putnikEntitet.getFirstname());
            putnik.setLastname(putnikEntitet.getLastname());
            putnik.setId(putnikEntitet.getId());
            putnik.setPassword(putnik.getPassword());
            putnik.setUsername(putnik.getUsername());
            putnici.add(putnik);
        }
        return putnici;
    }

    // nisam siguran kaj napraviti tocno s preuzmiLetoveBazePodataka
    public String preuzmiLetove(String icao, int odVremena, int doVremena) {
        if (this.preuzetiPodatke) {
            letovi = upravljanjePutnicima.preuzmiLetoveOpenSky(icao, odVremena, doVremena);
            // TODO navodi se da treba pozvati jos i preuzmiLetoveBazePodataka, al mi to uopce nema smisla jer metoda ^ to radi 
        } else {
            letovi = upravljanjePutnicima.preuzmiLetoveBazePodataka(icao, odVremena, doVremena);
        }
        return "";
    }

    // maknuti hardkodiran avionId. od kud uzeti avionId anyways? kak se pokazuje obavijest?
    public String dodajLet(int putnikId) {
        int avionId = 5;
        boolean letDodan = upravljanjePutnicima.dodajLet(putnikId, avionId);
        if (letDodan) {
            InformatorPutnika.saljiPoruku(String.valueOf(putnikId));
        } else {
            obavijest = "Let je neuspješno dodan";
        }
        return "";
    }
}
