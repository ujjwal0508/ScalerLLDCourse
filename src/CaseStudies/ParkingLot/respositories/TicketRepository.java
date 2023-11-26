package CaseStudies.ParkingLot.respositories;

import CaseStudies.ParkingLot.models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {

    private Map<Long, Ticket> tickets = new TreeMap<>();
    private Long previousId = 0L;

    public Ticket saveTicket(Ticket ticket){
        previousId += 1;
        ticket.setId(previousId);
        tickets.put(previousId, ticket);
        return ticket;
    }
}
