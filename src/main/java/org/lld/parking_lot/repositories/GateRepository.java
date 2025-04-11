package org.lld.parking_lot.repositories;

import org.lld.parking_lot.models.Gate;

import java.util.*;

public class GateRepository {

    private Map<Long, Gate> gateMap = new TreeMap<>();
    private Long previousGateId = 0L;

    public Gate save(Gate gate) {
        // update + insert => upsert
        if(gate.getId() == null) {
            //Insert
            previousGateId += 1;
            gate.setId(previousGateId);
        }
        //Update
        gateMap.put(gate.getId(), gate);
        return gate;
    }

    public Optional<Gate> findGateById(Long gateId) {
        if(gateMap.containsKey(gateId)) {
            return Optional.of(gateMap.get(gateId));
        }
        return Optional.empty();
    }

    public Gate delete(Gate gate) {
        gateMap.remove(gate.getId());
        return gate;
    }

}
