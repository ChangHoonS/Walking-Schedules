package com.example.schedules.schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.schedules.schedule.dto.responsedto.ScheduleFindAllResponseDto;
import com.example.schedules.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository <Schedule, Long> {

	default Schedule findByIdOrElseThrow(Long id) {
		return findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
	}

	@Query("select new com.example.schedules.schedule.dto.responsedto.ScheduleFindAllResponseDto(s.id, s.writerId, s.title, s.content, count(c) as commentCount) " +
		"from Schedule s left join Comment c on s.id=c.schedule.id group by s.id") // 마지막 group by 알아보기

	List<ScheduleFindAllResponseDto> findSchedulesCommentCount();
}
