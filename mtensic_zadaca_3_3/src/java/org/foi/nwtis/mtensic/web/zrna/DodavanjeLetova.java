package org.foi.nwtis.mtensic.web.zrna;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.foi.nwtis.mtensic.web.ws.InformatorPutnika;
import org.foi.nwtis.rest.klijenti.OSKlijent;
import org.foi.nwtis.rest.podaci.AvionLeti;

/**
 *
 * @author Monika
 */
@Named(value = "dodavanjeLetova")
@SessionScoped
public class DodavanjeLetova implements Serializable {

    private String odVremena;
    private String doVremena;
    private ArrayList<PodaciPutnika> putnici = new ArrayList<PodaciPutnika>();
    private int odabraniPutnik;
    private ArrayList<Aerodrom> aerodromi = new ArrayList<Aerodrom>();
    private String odabraniAerodrom;
    private ArrayList<PodaciLeta> letovi = new ArrayList<PodaciLeta>();
    private int odabraniLet;
    private boolean preuzetiPodatke;

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
        //dajSveAerodrome()
        return aerodromi;
    }

    public ArrayList<PodaciLeta> getLetovi() {
        //dajSveLetove()
        return letovi;
    }

    public ArrayList<PodaciPutnika> getPutnici() {
        //dajSvePutnike()
        return putnici;
    }

    public String preuzmiLetove() {
        if (this.preuzetiPodatke) {
            /*OSKlijent osk = new OSKlijent(username, password);
            List<AvionLeti> departures = new ArrayList<AvionLeti>();
            for (Aerodrom a : aerodromi) {
                System.out.println("icao: " + a.getIcao() + ", pocetak: " + pocetakIntervala + ", kraj: " + krajIntervala);
                departures = osk.getDepartures(a.getIcao(), pocetakIntervala, krajIntervala);
            }*/
            //preuzmiLetoveOpenSky
            //preuzmiLetoveBazePodataka(this.odVremena, this.doVremena, this.odabraniAerodrom)
        } else {
            //preuzmiLetoveBazePodataka(this.odVremena, this.doVremena, this.odabraniAerodrom)
        }
    }

    public String dodajLet(int id) {
        boolean letDodan = dodajLet(id);
        if (letDodan) {
            InformatorPutnika.saljiPoruku(String.valueOf(id));
        } else {
            // salji neku isusovu obavijest
        }
    }
}
