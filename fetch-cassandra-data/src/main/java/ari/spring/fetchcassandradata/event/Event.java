package ari.spring.fetchcassandradata.event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("events")
public class Event {
    
    @PrimaryKey
    private UUID id;
    @Column("station_id")
    private Long stationId;
    @Column("connection_id")
    private Long connectionId;
    private String parameter;
    @Column("event_ts")
    private LocalDateTime eventTs;
    private LocalDate date;
    private Double lat;
    private Double lon;
    private Double measure;
    @Column("received_at")
    private LocalDateTime receivedAt;
    @Column("sent_at")
    private LocalDateTime sentAt;


    public Event() {
    }

    public Event(UUID id, Long stationId, Long connectionId, String parameter, LocalDateTime eventTs, LocalDate date, Double lat, Double lon, Double measure, LocalDateTime receivedAt, LocalDateTime sentAt) {
        this.id = id;
        this.stationId = stationId;
        this.connectionId = connectionId;
        this.parameter = parameter;
        this.eventTs = eventTs;
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.measure = measure;
        this.receivedAt = receivedAt;
        this.sentAt = sentAt;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getStationId() {
        return this.stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public Long getConnectionId() {
        return this.connectionId;
    }

    public void setConnectionId(Long connectionId) {
        this.connectionId = connectionId;
    }

    public String getParameter() {
        return this.parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public LocalDateTime getEventTs() {
        return this.eventTs;
    }

    public void setEventTs(LocalDateTime eventTs) {
        this.eventTs = eventTs;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getLat() {
        return this.lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return this.lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getMeasure() {
        return this.measure;
    }

    public void setMeasure(Double measure) {
        this.measure = measure;
    }

    public LocalDateTime getReceivedAt() {
        return this.receivedAt;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    public LocalDateTime getSentAt() {
        return this.sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }


}
