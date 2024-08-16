package org.example.reservation.infrastructure.springdata.repository;

import org.example.reservation.infrastructure.springdata.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<EventEntity, Long> {
}
