package com.example.schedules.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.schedules.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository <Schedule, Long> {
	default Schedule findByIdOrElseThrow(Long id) {
		return findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));

	}
}
