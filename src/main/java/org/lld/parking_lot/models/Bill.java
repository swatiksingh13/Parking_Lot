package org.lld.parking_lot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Bill extends BaseModel{
    private Ticket ticket;
    private Gate gate;
    private Operator generatedBy;
    private BillStatus status;
    private Date exitTime;
    private int amount;
    private List<Payment> payments;
    private FeeCalculationStrategyType feeCalculationStrategyType;
}
