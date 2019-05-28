package org.foi.nwtis.mtensic.web.zrna;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import org.foi.nwtis.mtensic.ejb.sb.UpravljanjePutnicima;
import org.foi.nwtis.mtensic.podaci.PodaciLeta;
import org.foi.nwtis.mtensic.podaci.PodaciPutnika;
import org.foi.nwtis.mtensic.web.ws.InformatorPutnika;

/**
 *
 * @author Monika
 */
@Named(value = "pregledLetova")
@SessionScoped
public class PregledLetova implements Serializable {

    @EJB
    private UpravljanjePutnicima upravljanjePutnicima;

    private String odVremena;
    private String doVremena;
    private List<PodaciPutnika> putnici = new ArrayList<PodaciPutnika>();
    private int odabraniPutnik;
    private List<PodaciLeta> letovi = new ArrayList<PodaciLeta>();
    private int odabraniLet;
    private String obavijest;

    public PregledLetova() {
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

    public int getOdabraniLet() {
        return odabraniLet;
    }

    public void setOdabraniLet(int odabraniLet) {
        this.odabraniLet = odabraniLet;
    }

    public List<PodaciPutnika> getPutnici() {
        return putnici;
    }

    // TODO ne kuzim ovu metodu tocno, kaj se treba poslat kao obavijest? i kaj je tocno sa soketom?
    public String brisiLet(int id) {
        boolean letObrisan = upravljanjePutnicima.brisiLet(id);
        if (letObrisan) {
            InformatorPutnika.saljiPoruku(String.valueOf(id));
        } else {
            obavijest = "Nije moguće izbrisati let";
        }
        return "";
    }

    public String preuzmiLetove() {
        letovi.clear();
        letovi = upravljanjePutnicima.preuzmiLetovePutnika(odabraniPutnik, pretvoriDatumUSekunde(odVremena), pretvoriDatumUSekunde(doVremena));
        return "";
    }

    public int pretvoriDatumUSekunde(String datum) {
        DateFormat originalFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = null;
        try {
            date = originalFormat.parse(datum);
        } catch (ParseException ex) {
            Logger.getLogger(PregledLetova.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (int) date.getTime() / 1000;
    }

    public List<PodaciLeta> getLetovi() {
        return letovi;
    }

}
