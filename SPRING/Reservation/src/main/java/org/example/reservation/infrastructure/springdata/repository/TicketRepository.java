package org.example.reservation.infrastructure.springdata.repository;

import org.example.reservation.infrastructure.springdata.entity.TicketEntity;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<TicketEntity, Long> {
}
