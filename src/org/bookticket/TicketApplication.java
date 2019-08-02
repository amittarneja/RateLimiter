package org.bookticket;

/**
 * This is an application which will register the JAX-RS resources
 * @author Bhakti Mehta
 */

//import org.glassfish.jersey.server.ServerProperties;
//import org.glassfish.jersey.server.validation.ValidationFeature;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class TicketApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(TicketResource.class);
        return classes;
    }
}
