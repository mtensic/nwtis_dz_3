package org.foi.nwtis.mtensic.ejb.eb;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.foi.nwtis.mtensic.ejb.eb.Flights;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-27T21:47:16")
@StaticMetamodel(Airplanes.class)
public class Airplanes_ { 

    public static volatile SingularAttribute<Airplanes, Integer> lastseen;
    public static volatile SingularAttribute<Airplanes, Integer> estdepartureairporthorizdistance;
    public static volatile SingularAttribute<Airplanes, Integer> estdepartureairportvertdistance;
    public static volatile SingularAttribute<Airplanes, String> icao24;
    public static volatile SingularAttribute<Airplanes, String> estdepartureairport;
    public static volatile SingularAttribute<Airplanes, Integer> arrivalairportcandidatescount;
    public static volatile SingularAttribute<Airplanes, Integer> departureairportcandidatescount;
    public static volatile SingularAttribute<Airplanes, Integer> estarrivalairportvertdistance;
    public static volatile SingularAttribute<Airplanes, Integer> firstseen;
    public static volatile SingularAttribute<Airplanes, String> estarrivalairport;
    public static volatile SingularAttribute<Airplanes, Date> stored;
    public static volatile SingularAttribute<Airplanes, String> callsign;
    public static volatile ListAttribute<Airplanes, Flights> flightsList;
    public static volatile SingularAttribute<Airplanes, Integer> id;
    public static volatile SingularAttribute<Airplanes, Integer> estarrivalairporthorizdistance;

}