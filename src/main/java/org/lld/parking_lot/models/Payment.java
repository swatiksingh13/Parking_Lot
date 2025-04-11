package org.lld.parking_lot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Payment extends BaseModel {
    private int amount;
    private PaymentStatus status;
    private PaymentMode mode;
    private String transactionId;
    private Date paymentTime;
}
