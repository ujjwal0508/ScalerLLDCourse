package CaseStudies.ParkingLot;

import CaseStudies.ParkingLot.controllers.TicketController;
import CaseStudies.ParkingLot.respositories.GateRepository;
import CaseStudies.ParkingLot.respositories.ParkingLotRepository;
import CaseStudies.ParkingLot.respositories.TicketRepository;
import CaseStudies.ParkingLot.respositories.VehicleRepository;
import CaseStudies.ParkingLot.services.TicketService;

public class ParkingLotApplication {

    public static void main(String[] args) {
        //what should we initiate first?

        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, parkingLotRepository, ticketRepository);
        TicketController ticketController = new TicketController(ticketService);

        System.out.println("Listing to port :8080");
    }
}
