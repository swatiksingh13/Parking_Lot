package org.lld.parking_lot.controllers;

import org.lld.parking_lot.dtos.IssueTicketRequestDto;
import org.lld.parking_lot.dtos.IssueTicketResponseDto;
import org.lld.parking_lot.dtos.ResponseStatus;
import org.lld.parking_lot.exceptions.GateNotFoundException;
import org.lld.parking_lot.models.Ticket;
import org.lld.parking_lot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto) {
        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();
        try{
            Ticket ticket = ticketService.issueTicket(
                    issueTicketRequestDto.getGateId(),
                    issueTicketRequestDto.getVehicleType(),
                    issueTicketRequestDto.getVehicleNumber(),
                    issueTicketRequestDto.getOwnerName()

            );
            issueTicketResponseDto.setTicket(ticket);
            issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        }
        catch(GateNotFoundException gateNotFoundException){
            System.out.println("Gate not found: reason  " + gateNotFoundException.getMessage());
            issueTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return issueTicketResponseDto;
    }
}
