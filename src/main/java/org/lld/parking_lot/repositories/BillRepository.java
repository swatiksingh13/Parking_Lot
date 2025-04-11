package org.lld.parking_lot.repositories;

import org.lld.parking_lot.models.Bill;

import java.util.Map;
import java.util.TreeMap;

public class BillRepository {
    private Map<Long, Bill> billMap = new TreeMap<>();
    private Long previousBillId = 0L;

    public Bill save(Bill bill) {

        if (bill.getId() == null) {
            previousBillId += 1;
            bill.setId(previousBillId);
        }
        billMap.put(bill.getId(), bill);
        return bill;
    }

}
