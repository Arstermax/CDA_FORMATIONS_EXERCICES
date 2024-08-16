package org.example.reservation.infrastructure.springdata.portImpl;

import org.example.reservation.shared.dto.EventDTO;
import org.example.reservation.shared.port.EventPort;

import java.util.List;

public class EventPortImpl implements EventPort {
    @Override
    public EventDTO save(EventDTO book) {
        return null;
    }

    @Override
    public List<EventDTO> getAllEvent() {
        return null;
    }

    @Override
    public EventDTO getByIdEvent(int idEvent) {
        return null;
    }
}
