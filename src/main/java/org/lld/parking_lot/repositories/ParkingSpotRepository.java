package org.lld.parking_lot.repositories;

import org.lld.parking_lot.models.ParkingSpot;
import org.lld.parking_lot.models.ParkingSpotStatus;
import org.lld.parking_lot.models.VehicleType;

import java.util.*;

public class ParkingSpotRepository {
    private Map<Long, ParkingSpot> parkingSpotMap = new TreeMap<>();
    private Map<String, ParkingSpot> parkingSpotNumberMap = new TreeMap<>();
    private Long previousParkingSpotId = 0L;

    public ParkingSpot save(ParkingSpot parkingSpot) {
        if (parkingSpot.getId() == null) {
            previousParkingSpotId = previousParkingSpotId + 1;
            parkingSpot.setId(previousParkingSpotId);
        }
        parkingSpotMap.put(parkingSpot.getId(), parkingSpot);
        parkingSpotNumberMap.put(parkingSpot.getSpotNumber(), parkingSpot);
        return parkingSpot;
    }

    public ParkingSpot findParkingSpotById(Long parkingSpotId) {
        return parkingSpotMap.get(parkingSpotId);
    }

    public Optional<ParkingSpot> findParkingSpotBySpotNumber(String spotNumber) {
        return Optional.ofNullable(parkingSpotNumberMap.get(spotNumber));
    }

    public Optional<ParkingSpot> findParkingSpotBySpotNumberAndFloorId(String spotNumber, Long parkingFloorId) {
        return parkingSpotMap.values().stream().filter(
                parkingSpot -> parkingSpot.getSpotNumber().
                        equals(spotNumber) && parkingSpot.getParkingFloorId().
                        equals(parkingFloorId)).findFirst();
    }

    public List<ParkingSpot> findAll() {
        return List.copyOf(parkingSpotMap.values());
    }

    public List<ParkingSpot> findAllByParkingSpotStatus(
            ParkingSpotStatus parkingSpotStatus) {
        return parkingSpotMap.values().stream().filter(
                parkingSpot -> parkingSpot.getParkingSpotStatus() == parkingSpotStatus).toList();
    }
}