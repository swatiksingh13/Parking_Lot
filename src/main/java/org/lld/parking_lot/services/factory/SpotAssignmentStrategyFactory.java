package org.lld.parking_lot.services.factory;


import org.lld.parking_lot.models.ParkingSpot;
import org.lld.parking_lot.models.SpotAssignmentStrategyType;
import org.lld.parking_lot.services.strategies.CheapestSpotAssignmentStrategy;
import org.lld.parking_lot.services.strategies.NearestSpotAssignmentStrategy;
import org.lld.parking_lot.services.strategies.RandomSpotAssignmentStrategy;
import org.lld.parking_lot.services.strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        switch (spotAssignmentStrategyType) {
            case CHEAPEST:
                return new CheapestSpotAssignmentStrategy();
                case NEAREST:
                    return new NearestSpotAssignmentStrategy();
                    case RANDOM:
                        return new RandomSpotAssignmentStrategy();
                        default:
                            return null;
        }
    }
}
