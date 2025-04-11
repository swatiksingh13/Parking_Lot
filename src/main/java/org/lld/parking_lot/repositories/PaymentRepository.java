package org.lld.parking_lot.repositories;

import org.lld.parking_lot.models.Payment;

import java.util.*;

public class PaymentRepository {
    private Map<Long, Payment> paymentMap = new TreeMap<>();
    private Long previousPaymentId = 0L;

    public Payment save(Payment payment) {
        if(payment.getId() == null) {
            previousPaymentId += 1;
           payment.setId(previousPaymentId);
        }
        paymentMap.put(payment.getId(), payment);
        return payment;
    }

    public Payment findPaymentById(Long paymentId) {
        return paymentMap.get(paymentId);
    }
}
