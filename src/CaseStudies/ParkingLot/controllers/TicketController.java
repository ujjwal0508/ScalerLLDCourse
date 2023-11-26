package CaseStudies.ParkingLot.controllers;


import CaseStudies.ParkingLot.controllers.dtos.IsseTicketResponseDTO;
import CaseStudies.ParkingLot.controllers.dtos.IssueTicketRequestDTO;
import CaseStudies.ParkingLot.controllers.dtos.ResponseStatus;
import CaseStudies.ParkingLot.models.Ticket;
import CaseStudies.ParkingLot.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    IsseTicketResponseDTO issueTicket(IssueTicketRequestDTO ticketRequestDTO){
        IsseTicketResponseDTO response = new IsseTicketResponseDTO();
        Ticket ticket;
        try {
            ticket = ticketService.issueTicket(ticketRequestDTO.getVehicleType(), ticketRequestDTO.getVehicleNumber(), ticketRequestDTO.getVehicleOwnerName(), ticketRequestDTO.getGateId());
        } catch (Exception e){
           response.setResponseStatus(ResponseStatus.FAILURE);
           response.setFailureReason(e.toString());
           return response;
        }
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setTicket(ticket);
        return  response;
    }
}
