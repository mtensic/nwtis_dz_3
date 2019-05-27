package org.foi.nwtis.mtensic.ejb.eb;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.foi.nwtis.mtensic.ejb.eb.Flights;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-27T21:47:16")
@StaticMetamodel(Passangers.class)
public class Passangers_ { 

    public static volatile SingularAttribute<Passangers, String> password;
    public static volatile SingularAttribute<Passangers, String> firstname;
    public static volatile SingularAttribute<Passangers, Date> stored;
    public static volatile ListAttribute<Passangers, Flights> flightsList;
    public static volatile SingularAttribute<Passangers, Integer> id;
    public static volatile SingularAttribute<Passangers, String> email;
    public static volatile SingularAttribute<Passangers, String> username;
    public static volatile SingularAttribute<Passangers, String> lastname;

}