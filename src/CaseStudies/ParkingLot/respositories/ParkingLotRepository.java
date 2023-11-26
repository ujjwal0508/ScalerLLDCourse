package CaseStudies.ParkingLot.respositories;

import CaseStudies.ParkingLot.models.Gate;
import CaseStudies.ParkingLot.models.ParkingLot;

import java.util.Map;
import java.util.TreeMap;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLotMap = new TreeMap<>();
    public ParkingLot getParkingLotByGate(Gate gate){

        for(ParkingLot parkingLot: parkingLotMap.values()){
            if(parkingLot.getGates().contains(gate))
                return parkingLot;
        }
        return null;
    }
}
