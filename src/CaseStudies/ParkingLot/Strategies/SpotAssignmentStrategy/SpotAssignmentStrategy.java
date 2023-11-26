package CaseStudies.ParkingLot.Strategies.SpotAssignmentStrategy;

import CaseStudies.ParkingLot.models.Gate;
import CaseStudies.ParkingLot.models.ParkingSpot;
import CaseStudies.ParkingLot.models.VehicleType;

public interface SpotAssignmentStrategy {

    ParkingSpot getSpot(Gate gate, VehicleType vehicleType);
}
