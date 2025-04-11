package org.lld.parking_lot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate extends BaseModel {
    private ParkingLot parkingLot;
    private GateType gateType;
    private GateStatus gateStatus;
    private Operator operator;

    @Override
    public String toString() {
        return "Gate{" +
                "id=" + this.getId() +
                ", parkingLot=" + parkingLot +
                ", gateType=" + gateType +
                ", gateStatus=" + gateStatus +
                ", operator=" + operator +
                '}';
    }
}
