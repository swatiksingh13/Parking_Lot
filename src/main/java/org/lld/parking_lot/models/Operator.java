package org.lld.parking_lot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Operator extends BaseModel {
    private String name;
    private int empId;

    @Override
    public String toString() {
        return "Operator{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                '}';
    }
}
