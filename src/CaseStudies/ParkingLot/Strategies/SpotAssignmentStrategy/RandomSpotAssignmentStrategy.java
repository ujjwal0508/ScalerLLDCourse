package CaseStudies.ParkingLot.Strategies.SpotAssignmentStrategy;

import CaseStudies.ParkingLot.models.*;
import CaseStudies.ParkingLot.respositories.ParkingLotRepository;;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{

    private ParkingLotRepository parkingLotRepository;
    @Override
    public ParkingSpot getSpot(Gate gate, VehicleType vehicleType) {

        ParkingLot parkingLot = parkingLotRepository.getParkingLotByGate(gate);

        for(ParkingFloor parkingFloor: parkingLot.getParkingFloors()){
            for(ParkingSpot parkingSpot: parkingFloor.getParkingSlots()){
                if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY) && parkingSpot.getSupportedVehicleTypes().contains(vehicleType)){
                    return parkingSpot;
                }
            }
        }

        return null;
    }
}
