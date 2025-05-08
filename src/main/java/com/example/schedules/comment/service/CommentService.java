package com.example.schedules.comment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.schedules.comment.dto.requestdto.CommentRequestDto;
import com.example.schedules.comment.dto.requestdto.CommentUpdateRequestDto;
import com.example.schedules.comment.dto.responsedto.CommentGetResponseDto;
import com.example.schedules.comment.dto.responsedto.CommentResponseDto;
import com.example.schedules.comment.entity.Comment;
import com.example.schedules.comment.repository.CommentRepository;
import com.example.schedules.schedule.entity.Schedule;
import com.example.schedules.schedule.repository.ScheduleRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final ScheduleRepository scheduleRepository;

	@Transactional
	public CommentResponseDto registerComment(Long scheduleId, CommentRequestDto commentRequestDto) {

		Schedule schedule = getScheduleId(scheduleId);

		Comment comment = Comment.builder()
			.writerId(commentRequestDto.getWriterId())
			.content(commentRequestDto.getContent())
			.schedule(schedule)
			.build();

		Comment savedComment = commentRepository.save(comment);

		return CommentResponseDto.from(savedComment);
	}

	@Transactional
	public CommentResponseDto updateComment(Long scheduleId, Long id, CommentUpdateRequestDto commentUpdateRequestDto) {

		getScheduleId(scheduleId);

		Comment findByIdComment = commentRepository.findByIdOrElseThrow(id);

		findByIdComment.updateComment(commentUpdateRequestDto);

		return CommentResponseDto.from(findByIdComment);
	}

	public List<CommentGetResponseDto> findAll(Long scheduleId) {

		getScheduleId(scheduleId);

		List<Comment> comment = commentRepository.findAll();

		return comment
			.stream()
			.map(CommentGetResponseDto::from)
			.collect(Collectors.toList());
	}

	public CommentGetResponseDto findComment(Long scheduleId, Long id) {

		getScheduleId(scheduleId);

		Comment findComment = commentRepository.findByIdOrElseThrow(id);

		return CommentGetResponseDto.from(findComment);
	}

	@Transactional
	public void delete(Long scheduleId, Long id) {

		getScheduleId(scheduleId);

		Comment findByIdComment = commentRepository.findByIdOrElseThrow(id);

		commentRepository.delete(findByIdComment);
	}

	public Schedule getScheduleId(Long scheduleId) {

		Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

		return schedule;
	}

}
