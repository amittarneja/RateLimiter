package org.bookticket;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A basic collection of Ticket orders for simplicity
 */
@Singleton
public class TicketService {
    private static final HashMap<Integer, Ticket> tickets = new HashMap<Integer, Ticket>();
    private static AtomicInteger orderCounter = new AtomicInteger(0);

    public static int incrementOrderCounter() {
        return orderCounter.incrementAndGet();
    }


    public static int addTicket(Ticket ticket) {
        int counter = incrementOrderCounter();
        tickets.put(counter, ticket);
        return counter;
    }

    public static int getSize() {
        return  tickets.size();
    }

    public static Ticket getTicket(int order) {
        return tickets.get(order);
    }

    public TicketService() {
        // initial content
        addTicket(new Ticket("AquaMan", "Gold", 19.50));

    }

    public static int getCounter() {

        return orderCounter.get();
    }
}