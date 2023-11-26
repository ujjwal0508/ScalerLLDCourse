package CaseStudies.ParkingLot.respositories;

import CaseStudies.ParkingLot.models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {

    private Map<Long, Gate> gates = new TreeMap<>();

    public Optional<Gate> getGateById(Long id){

        if(gates.containsKey(id))
            return Optional.of(gates.get(id));

        return Optional.empty();
    }

    //Optional is a wrapper over an object
}
