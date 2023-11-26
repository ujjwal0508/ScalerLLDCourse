package CaseStudies.ParkingLot.Strategies.SpotAssignmentStrategy;


import CaseStudies.ParkingLot.models.SpotAssignmentStrategyType;

public class SpotAssignmentStrategyFactory {

    public static SpotAssignmentStrategy getSpotForType(SpotAssignmentStrategyType type){
        return new RandomSpotAssignmentStrategy();
    }
}
