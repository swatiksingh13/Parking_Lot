package org.lld.parking_lot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingFloor extends BaseModel {
    private int floorNumber;
    private List<ParkingSpot> parkingSpots;
    private ParkingFloorStatus parkingFloorStatus;

    @Override
    public String toString() {
        return "ParkingFloor{" +
                "floorId=" + this.getId() +
                ", floorNumber=" + floorNumber +
                ", parkingSpots=" + parkingSpots +
                ", parkingFloorStatus=" + parkingFloorStatus +
                '}';
    }
}
