package org.foi.nwtis.mtensic.web.zrna;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.foi.nwtis.mtensic.web.ws.InformatorPutnika;

/**
 *
 * @author Monika
 */
@Named(value = "pregledLetova")
@SessionScoped
public class PregledLetova implements Serializable {
    private String odVremena;
    private String doVremena;
    private ArrayList<Putnik> putnici = new ArrayList<Putnik>();
    private int odabraniPutnik;
    private ArrayList<Let> letovi = new ArrayList<Let>();
    private int odabraniLet;
    
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

    public <any> getPutnici() {
        return putnici;
    }
    
    public String brisiLet(int id) {
        boolean letObrisan = obrisiLet(id);
        if (letObrisan) {
            InformatorPutnika.saljiPoruku(id);
        } else {
            // neka obavijest
        }
    }

}
