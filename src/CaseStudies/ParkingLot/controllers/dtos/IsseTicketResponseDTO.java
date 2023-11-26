package CaseStudies.ParkingLot.controllers.dtos;


import CaseStudies.ParkingLot.models.Ticket;

public class IsseTicketResponseDTO {

    private Ticket ticket;
    private ResponseStatus responseStatus;
    private String failureReason;

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
