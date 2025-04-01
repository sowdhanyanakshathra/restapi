package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String eventName;
    private String eventMonth;
    private String eventYear;
    private LocalDateTime eventDateTime;

    public Event() {
    }

    public Event(Long id, String eventName, String eventMonth, String eventYear, LocalDateTime eventDateTime) {
        this.id = id;
        this.eventName = eventName;
        this.eventMonth = eventMonth;
        this.eventYear = eventYear;
        this.eventDateTime = eventDateTime;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventMonth() {
        return eventMonth;
    }
    public void setEventMonth(String eventMonth) {
        this.eventMonth = eventMonth;
    }

    public String getEventYear() {
        return eventYear;
    }
    public void setEventYear(String eventYear) {
        this.eventYear = eventYear;
    }
    
    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }
    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }
}
