package org.foi.nwtis.mtensic.ejb.eb;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.foi.nwtis.mtensic.ejb.eb.Airports;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-27T21:47:16")
@StaticMetamodel(Myairports.class)
public class Myairports_ { 

    public static volatile SingularAttribute<Myairports, String> ident;
    public static volatile SingularAttribute<Myairports, Date> stored;
    public static volatile SingularAttribute<Myairports, String> name;
    public static volatile SingularAttribute<Myairports, String> coordinates;
    public static volatile SingularAttribute<Myairports, String> isoCountry;
    public static volatile SingularAttribute<Myairports, Airports> airports;

}