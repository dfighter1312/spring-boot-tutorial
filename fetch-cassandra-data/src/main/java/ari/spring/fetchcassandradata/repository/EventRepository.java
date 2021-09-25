package ari.spring.fetchcassandradata.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import ari.spring.fetchcassandradata.event.Event;

public interface EventRepository extends CassandraRepository<Event, UUID> {
    
    @AllowFiltering
    List<Event> findByStationId(Long stationId);

    @AllowFiltering
    List<Event> findByConnectionId(Long connectionId);
    
    @AllowFiltering
    List<Event> findByParameter(String parameter);

}
