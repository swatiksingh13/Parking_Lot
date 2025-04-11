package org.lld.parking_lot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingSpot extends BaseModel {
    private String spotNumber;
    private ParkingSpotStatus parkingSpotStatus;
    private List<VehicleType> supportedVehicleTypes;
    private Long parkingFloorId;

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "parkingSpotId=" + this.getId() +
                ", spotNumber='" + spotNumber + '\'' +
                ", parkingSpotStatus=" + parkingSpotStatus +
                ", vehicleTypes=" + supportedVehicleTypes +
                ", parkingFloorId=" + parkingFloorId +
                '}';
    }
}
