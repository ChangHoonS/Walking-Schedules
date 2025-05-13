package com.example.schedules.schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.schedules.common.exception.CustomException;
import com.example.schedules.common.exception.ErrorCode;
import com.example.schedules.schedule.dto.responsedto.ScheduleFindAllResponseDto;
import com.example.schedules.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository <Schedule, Long> {

	default Schedule findByIdOrElseThrow(Long id) {
		return findById(id)
			.orElseThrow(() -> new CustomException(ErrorCode.SCHEDULE_NOT_FOUND));
	}

	@Query("select new com.example.schedules.schedule.dto.responsedto.ScheduleFindAllResponseDto(s.id, s.writerId, s.title, s.content, count(c) as commentCount) " +
		"from Schedule s left join Comment c on s.id=c.schedule.id group by s.id") // 마지막 group by 알아보기

	List<ScheduleFindAllResponseDto> findSchedulesCommentCount();
}
