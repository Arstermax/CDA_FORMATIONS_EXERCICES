package org.example.tp_architecture.domain.service.impl;

import org.example.tp_architecture.domain.service.ManageEventService;
import org.example.tp_architecture.shared.dto.EventDTO;
import org.example.tp_architecture.shared.dto.ReservationDTO;

import java.time.LocalDate;
import java.util.List;

public class ManageEventServiceImpl implements ManageEventService {
    @Override
    public EventDTO createEvent(String name, LocalDate date, String location, int availableTickets) {
        return null;
    }

    @Override
    public List<EventDTO> listEvents() {
        return List.of();
    }

    @Override
    public ReservationDTO reserveTicket(int eventId, String user, int numberOfTickets) {
        return null;
    }

    @Override
    public void cancelReservation(int id) {

    }

    @Override
    public List<ReservationDTO> listReservations() {
        return List.of();
    }
}
