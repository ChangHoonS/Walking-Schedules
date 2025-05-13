package com.example.schedules.schedule.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.schedules.comment.dto.responsedto.CommentGetResponseDto;
import com.example.schedules.comment.entity.Comment;
import com.example.schedules.comment.repository.CommentRepository;
import com.example.schedules.schedule.dto.requestdto.ScheduleRequestDto;
import com.example.schedules.schedule.dto.requestdto.ScheduleUpdateRequestDto;
import com.example.schedules.schedule.dto.responsedto.ScheduleFindAllResponseDto;
import com.example.schedules.schedule.dto.responsedto.ScheduleResponseDto;
import com.example.schedules.schedule.dto.responsedto.ScheduleWithCommentResponseDto;
import com.example.schedules.schedule.entity.Schedule;
import com.example.schedules.schedule.repository.ScheduleRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleService {

	private final ScheduleRepository scheduleRepository;
	private final CommentRepository commentRepository;

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

	public ScheduleWithCommentResponseDto findSchedule(Long id) {

		Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

		List<Comment> comment = commentRepository.findAllByScheduleId(id);

		List<CommentGetResponseDto> commentGetResponseDto = comment.stream()
			.sorted(Comparator.comparing(Comment::getCreatedAt))
			.map(CommentGetResponseDto::from)
			.collect(Collectors.toList());

		return ScheduleWithCommentResponseDto.from(findSchedule, commentGetResponseDto);
	}

	@Transactional
	public void delete(Long id) {

		Schedule findByIdSchedule = scheduleRepository.findByIdOrElseThrow(id);

		scheduleRepository.delete(findByIdSchedule);
	}

}
