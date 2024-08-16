package org.example.tp_architecture.domain.service;

import org.example.tp_architecture.shared.dto.EventDTO;
import org.example.tp_architecture.shared.dto.ReservationDTO;

import java.time.LocalDate;
import java.util.List;

public interface ManageEventService {
    EventDTO createEvent(String name, LocalDate date, String location, int availableTickets);
    List<EventDTO> listEvents();
    ReservationDTO reserveTicket(int eventId, String user, int numberOfTickets);
    void cancelReservation(int id);
    List<ReservationDTO> listReservations();
}
