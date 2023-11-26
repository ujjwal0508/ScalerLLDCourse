package CaseStudies.ParkingLot.respositories;

import CaseStudies.ParkingLot.models.Vehicle;

import java.util.Optional;

public class VehicleRepository {

    public Optional<Vehicle> getVehicleByNumber(String number){
        return Optional.empty();
    }

    public Vehicle saveVehicle(Vehicle vehicle){
        return vehicle;
    }
}
