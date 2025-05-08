package com.example.schedules.schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.schedules.schedule.dto.requestdto.ScheduleRequestDto;
import com.example.schedules.schedule.dto.requestdto.ScheduleUpdateRequestDto;
import com.example.schedules.schedule.dto.responsedto.ScheduleFindAllResponseDto;
import com.example.schedules.schedule.dto.responsedto.ScheduleResponseDto;
import com.example.schedules.schedule.entity.Schedule;
import com.example.schedules.schedule.repository.ScheduleRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleService {

	private final ScheduleRepository scheduleRepository;

	@Transactional
	public ScheduleResponseDto registerSchedule(ScheduleRequestDto scheduleRequestDto) {

		Schedule schedule = Schedule.builder()
			.writerId(scheduleRequestDto.getWriterId())
			.title(scheduleRequestDto.getTitle())
			.content(scheduleRequestDto.getContent())
			.build();

		Schedule savedSchedule = scheduleRepository.save(schedule);

		return ScheduleResponseDto.from(savedSchedule);
	}

	@Transactional
	public ScheduleResponseDto updateSchedule(Long id, ScheduleUpdateRequestDto scheduleUpdateRequestDto) {

		Schedule findByIdSchedule = scheduleRepository.findByIdOrElseThrow(id);

		findByIdSchedule.updateSchedule(scheduleUpdateRequestDto);

		return ScheduleResponseDto.from(findByIdSchedule);
	}

	public List<ScheduleFindAllResponseDto> findAll() {

		return scheduleRepository.findSchedulesCommentCount();

	}

	public ScheduleResponseDto findSchedule(Long id) {

		Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

		return ScheduleResponseDto.from(findSchedule);
	}

	@Transactional
	public void delete(Long id) {

		Schedule findByIdSchedule = scheduleRepository.findByIdOrElseThrow(id);

		scheduleRepository.delete(findByIdSchedule);
	}

	// public List<ScheduleCommentCountDto> getScheduleCommentCounts() {
	// 	return scheduleRepository.findScheduleCommentCounts();
	// }

}
