package org.foi.nwtis.mtensic.ejb.eb;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.foi.nwtis.mtensic.ejb.eb.Airplanes;
import org.foi.nwtis.mtensic.ejb.eb.Passangers;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-27T21:47:16")
@StaticMetamodel(Flights.class)
public class Flights_ { 

    public static volatile SingularAttribute<Flights, Passangers> passanger;
    public static volatile SingularAttribute<Flights, Date> stored;
    public static volatile SingularAttribute<Flights, Airplanes> airplane;
    public static volatile SingularAttribute<Flights, Integer> id;

}