package org.example.reservation.domain.service;

import org.example.reservation.domain.entity.Event;
import org.example.reservation.infrastructure.springdata.repository.TicketRepository;
import org.example.reservation.shared.dto.TicketDTO;
import org.example.reservation.shared.port.TicketPort;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketPort ticketPort;

    public TicketService(TicketPort ticketPort) {
        this.ticketPort = ticketPort;
    }
}
