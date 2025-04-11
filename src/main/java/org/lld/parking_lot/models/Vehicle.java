package org.lld.parking_lot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseModel {
    private String number;
    private VehicleType type;
    private String ownerName;

    @Override
    public String toString() {
        return number;
    }

}
