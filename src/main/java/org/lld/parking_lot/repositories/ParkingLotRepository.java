package org.lld.parking_lot.repositories;

import org.lld.parking_lot.models.ParkingLot;

import java.util.*;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLotMap = new TreeMap<>();
    private Long previousParkingLotId = 0L;

    public ParkingLot save(ParkingLot parkingLot) {
        if (parkingLot.getId() == null) {
            previousParkingLotId += 1;
            parkingLot.setId(previousParkingLotId);
        }
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }

    public ParkingLot findParkingLotById(Long parkingLotId) {
        return parkingLotMap.get(parkingLotId);
    }
}
