package org.lld.parking_lot.dtos;

import lombok.Getter;
import lombok.Setter;
import org.lld.parking_lot.models.Ticket;

@Getter
@Setter
public class IssueTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;
}
