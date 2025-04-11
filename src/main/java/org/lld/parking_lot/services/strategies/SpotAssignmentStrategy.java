package org.lld.parking_lot.services.strategies;

import org.lld.parking_lot.models.Gate;
import org.lld.parking_lot.models.ParkingSpot;
import org.lld.parking_lot.models.VehicleType;
import org.lld.parking_lot.repositories.ParkingSpotRepository;

public interface SpotAssignmentStrategy {
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate, ParkingSpotRepository parkingSpotRepository);

}
