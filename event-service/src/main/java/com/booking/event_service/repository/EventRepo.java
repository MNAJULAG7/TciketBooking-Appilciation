package com.booking.event_service.repository;

import com.booking.event_service.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event,Long> {

    List<Event> findAllByLocation(String location);
}
