package CaseStudies.ParkingLot.services;

import CaseStudies.ParkingLot.Exceptions.GateNotFoundException;
import CaseStudies.ParkingLot.Strategies.SpotAssignmentStrategy.SpotAssignmentStrategy;
import CaseStudies.ParkingLot.Strategies.SpotAssignmentStrategy.SpotAssignmentStrategyFactory;
import CaseStudies.ParkingLot.models.*;
import CaseStudies.ParkingLot.respositories.GateRepository;
import CaseStudies.ParkingLot.respositories.ParkingLotRepository;
import CaseStudies.ParkingLot.respositories.TicketRepository;
import CaseStudies.ParkingLot.respositories.VehicleRepository;
import java.util.Date;
import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(VehicleType vehicleType,
                              String vehicleNumber,
                              String vehicleOwnerName,
                              Long gateId) throws Exception {
        // create a ticket object
        //assign a spot
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gate> gateOptional = gateRepository.getGateById(gateId);
        if (gateOptional.isEmpty()) {
            throw new GateNotFoundException();
        }

        Gate gate = gateOptional.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        //check if vehicle in database
        //1. yes ->
        // get vehicle from database
        // put in ticket object
        //2. no ->
        // create object of vehicle and save in database
        // put in database

        Optional<Vehicle> vehicleOptional = vehicleRepository.getVehicleByNumber(vehicleNumber);
        Vehicle savedVehicle;
        if (vehicleOptional.isEmpty()) {
            Vehicle vehicle = new Vehicle(vehicleNumber, vehicleType, vehicleOwnerName);
            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        } else {
            savedVehicle = vehicleOptional.get();
        }

        ticket.setVehicle(savedVehicle);

        SpotAssignmentStrategyType spotAssignmentStrategyType = parkingLotRepository.getParkingLotByGate(gate).getSlotAssignmentStrategyType();
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotForType(spotAssignmentStrategyType);
        ticket.setAssignedSlot(spotAssignmentStrategy.getSpot(gate, vehicleType));

        Ticket savedTicket = ticketRepository.saveTicket(ticket);
        ticket.setNumber("TICKET-" + savedTicket.getId());
        return ticket;
    }
}
