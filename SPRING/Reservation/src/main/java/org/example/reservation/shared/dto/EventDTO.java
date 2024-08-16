package org.example.reservation.shared.dto;

import java.time.LocalDate;

public class EventDTO {
    private long eventID;
    private String eventName;
    private String eventType;
    private LocalDate eventDate;

    public EventDTO(String eventName, String eventType, LocalDate eventDate) {
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDate = eventDate;
    }

    public EventDTO(long eventID, String eventName, String eventType, LocalDate eventDate) {
        this(eventName, eventType, eventDate);
        this.eventID = eventID;
    }

    public long getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }
}
