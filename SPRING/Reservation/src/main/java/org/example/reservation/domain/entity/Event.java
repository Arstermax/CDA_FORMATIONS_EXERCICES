package org.example.reservation.domain.entity;

import java.time.LocalDate;

public class Event {

    private long eventID;
    private String eventName;
    private String eventType;
    private LocalDate eventDate;

    public Event(long eventID, String eventName, String eventType, LocalDate eventDate) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDate = eventDate;
    }

    public Event(String eventName, String eventType, LocalDate eventDate) {
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDate = eventDate;
    }

    public long getEventID() {
        return eventID;
    }

    public void setEventID(long eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}
