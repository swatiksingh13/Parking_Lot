package org.lld.parking_lot.repositories;

import org.lld.parking_lot.models.ParkingFloor;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingFloorRepository {
    private Map<Long, ParkingFloor> parkingFloorMap = new TreeMap<>();
    private Long previousParkingFloorId = 0L;

    public ParkingFloor save(ParkingFloor parkingFloor) {
        if(parkingFloor.getId() == null){
            previousParkingFloorId += 1;
            parkingFloor.setId(previousParkingFloorId);
        }
        parkingFloorMap.put(parkingFloor.getId(), parkingFloor);
        return parkingFloor;
    }

    public Optional<ParkingFloor> findParkingFloorByGateId(Long parkingFloorId) {
        if(parkingFloorMap.containsKey(parkingFloorId)) {
            return Optional.of(parkingFloorMap.get(parkingFloorId));
        }
        return Optional.empty();
    }

//    public ParkingFloor findParkingFloorById(Long parkingFloorId) {
//        return parkingFloorMap.get(parkingFloorId);
//    }
}
