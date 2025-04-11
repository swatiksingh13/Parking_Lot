package org.lld.parking_lot.dtos;

import lombok.Getter;
import lombok.Setter;
import org.lld.parking_lot.models.VehicleType;

@Getter
@Setter
public class IssueTicketRequestDto {
    private Long gateId;
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String ownerName;
}
