package org.bookticket;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * A simple JAX-RS resource which is to demonstrate the rate limiting functionality for an application.
 *
 */
@Path("v1/tickets")
public class TicketResource {


    @GET
    @Path("{order}")
    @Produces(MediaType.APPLICATION_JSON)
    @NotNull(message="Ticket does not exist for the order id requested")
    public Ticket getTicket(  @PathParam("order") int order) {
        return TicketService.getTicket(order);

    }


}