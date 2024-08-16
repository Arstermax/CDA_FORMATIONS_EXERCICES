package org.example.reservation.shared.port;

import org.example.reservation.shared.dto.EventDTO;

import java.util.List;

public interface EventPort {
    EventDTO save(EventDTO book);
    List<EventDTO> getAllEvent();

    EventDTO getByIdEvent(int idEvent);

}
