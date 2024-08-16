package org.example.reservation.shared.dto;

import org.example.reservation.domain.entity.Event;

public class TicketDTO {
    private long id;
    private Event event;
    private boolean isPlanned;

    public TicketDTO(long id, Event event, boolean isPlanned) {
        this(event, isPlanned);
        this.id = id;
    }

    public TicketDTO(Event event, boolean isPlanned) {
        this.event = event;
        this.isPlanned = isPlanned;
    }

    public long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public boolean isPlanned() {
        return isPlanned;
    }
}
