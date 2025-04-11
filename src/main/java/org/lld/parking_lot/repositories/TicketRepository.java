package org.lld.parking_lot.repositories;

import org.lld.parking_lot.models.Ticket;

import java.util.*;

public class TicketRepository {
    private Map<Long, Ticket> ticketMap = new TreeMap<>();
    private Long previousTicketId = 0L;

    public Ticket save(Ticket ticket) {
        if(ticket.getId() == null) {
            previousTicketId += 1;
            ticket.setId(previousTicketId);
        }
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }
    public Ticket findTicketById(Long ticketId) {
        return ticketMap.get(ticketId);
    }

}
