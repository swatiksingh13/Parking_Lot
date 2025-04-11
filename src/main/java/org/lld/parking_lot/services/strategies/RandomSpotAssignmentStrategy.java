package org.lld.parking_lot.services.strategies;

import org.lld.parking_lot.models.Gate;
import org.lld.parking_lot.models.ParkingSpot;
import org.lld.parking_lot.models.ParkingSpotStatus;
import org.lld.parking_lot.models.VehicleType;
import org.lld.parking_lot.repositories.ParkingSpotRepository;

import java.util.Optional;
import java.util.Random;

public class RandomSpotAssignmentStrategy  implements SpotAssignmentStrategy {
    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate, ParkingSpotRepository parkingSpotRepository) {
        Optional<ParkingSpot> parkingSpotOptional  = Optional.empty();
        do {
            Random random = new Random();
            int spotNumber = random.nextInt(10) + 1;
            char spotChar = (char) (random.nextInt(26) + 'A');
            String spotStr = spotChar + String.valueOf(spotNumber);
            int floorNumber = random.nextInt(10) + 1;
            parkingSpotOptional  = parkingSpotRepository.findParkingSpotBySpotNumberAndFloorId(spotStr, (long) floorNumber);

        } while (parkingSpotOptional.isEmpty() || parkingSpotOptional.get().getParkingSpotStatus() == ParkingSpotStatus.OCCUPIED);
        ParkingSpot parkingSpot = parkingSpotOptional.get();
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        return parkingSpot;
    }
}
