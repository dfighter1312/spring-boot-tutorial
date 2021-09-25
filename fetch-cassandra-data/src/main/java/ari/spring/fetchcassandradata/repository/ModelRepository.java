package ari.spring.fetchcassandradata.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import ari.spring.fetchcassandradata.model.Model;

public interface ModelRepository extends CassandraRepository<Model, UUID> {
    
    List<Model> findByTitle(String title);

    List<Model> findByDescription(String description);

}
