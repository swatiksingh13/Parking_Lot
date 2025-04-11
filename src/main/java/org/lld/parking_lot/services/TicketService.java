package org.lld.parking_lot.services;

import org.lld.parking_lot.exceptions.GateNotFoundException;
import org.lld.parking_lot.models.*;
import org.lld.parking_lot.repositories.*;
import org.lld.parking_lot.services.factory.SpotAssignmentStrategyFactory;
import org.lld.parking_lot.services.strategies.SpotAssignmentStrategy;

import java.util.*;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public TicketService(ParkingSpotRepository parkingSpotRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository,
                         VehicleRepository vehicleRepository,
                         GateRepository gateRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
        this.vehicleRepository = vehicleRepository;
        this.gateRepository = gateRepository;
    }

    public Ticket issueTicket(Long gateId,
                              VehicleType vehicleType,
                              String vehicleNumber,
                              String ownerName) throws GateNotFoundException {

        Ticket ticket = new Ticket();

        ticket.setEntryTime(new Date());

        // find gate by id
        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);
        if (optionalGate.isEmpty()) {
            throw new GateNotFoundException("Gate not found with id: " + gateId);
        }
        Gate gate = optionalGate.get();

        ticket.setGeneratedAt(gate);
         /*
         Get the vehicle object with number
         If vehicle not found, create a new vehicle object
         and save it in the vehicle repository
         */

        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle savedVehicle = null;
        if (optionalVehicle.isEmpty()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setNumber(vehicleNumber);
            vehicle.setType(vehicleType);
            vehicle.setOwnerName(ownerName);
            savedVehicle = vehicleRepository.save(vehicle);
        } else {
            savedVehicle = optionalVehicle.get();
        }

        ticket.setVehicle(savedVehicle);

        // assign the spot to the vehicle
        Long parkingLotId = gate.getParkingLot().getId();
        ParkingLot parkingLot = parkingLotRepository.findParkingLotById(parkingLotId);
        SpotAssignmentStrategyType spotAssignmentStrategyType = parkingLot.getSpotAssignmentStrategyType();
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(spotAssignmentStrategyType);
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate, parkingSpotRepository);
        ticket.setParkingSpot(parkingSpot);
        // Set a random alphanumeric string for the ticket
        ticket.setNumber(RandomStringGenerationService.generateRandomAlphanumericString());
        return ticketRepository.save(ticket);
    }
}

/*
        1. Get the gate object from the Database.
        2. If gateId is invalid, throw an exception.
        3. Check if the vehicle with the number is present in the DB or not.
        4. If vehicle is not present, create a new vehicle object and save it to the DB.
        5. Assign the Parking Spot.
        6. Generate and return the ticket.
         */

