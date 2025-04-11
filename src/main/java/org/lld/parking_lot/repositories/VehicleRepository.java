package org.lld.parking_lot.repositories;

import org.lld.parking_lot.models.Ticket;
import org.lld.parking_lot.models.Vehicle;

import java.util.*;

public class VehicleRepository {
    private Map<Long, Vehicle> vehicleMap = new TreeMap<>();
    private Map<String, Vehicle> vehicleNumberMap = new TreeMap<>();
    private Long previousVehicleId = 0L;

    public Vehicle save(Vehicle vehicle) {
        if(vehicle.getId() == null) {
            previousVehicleId += 1;
            vehicle.setId(previousVehicleId);
        }
        vehicleMap.put(vehicle.getId(), vehicle);
        // add it to vehicle number map
        vehicleNumberMap.put(vehicle.getNumber(), vehicle);
        return vehicle;
    }

    public Optional<Vehicle> findTicketById(Long vehicleId) {
       if(vehicleMap.containsKey(vehicleId)) {
           return Optional.of(vehicleMap.get(vehicleId));
       }
       return Optional.empty();
    }

    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber) {
        if (vehicleNumberMap.containsKey(vehicleNumber)) {
            return Optional.of(vehicleNumberMap.get(vehicleNumber));
        }
        return Optional.empty();
    }

}
