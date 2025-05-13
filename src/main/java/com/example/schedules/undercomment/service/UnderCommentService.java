package com.example.schedules.undercomment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.schedules.comment.dto.responsedto.CommentResponseDto;
import com.example.schedules.comment.entity.Comment;
import com.example.schedules.comment.repository.CommentRepository;
import com.example.schedules.common.exception.CustomException;
import com.example.schedules.common.exception.ErrorCode;
import com.example.schedules.schedule.entity.Schedule;
import com.example.schedules.schedule.repository.ScheduleRepository;
import com.example.schedules.undercomment.dto.requestdto.UnderCommentRequestDto;
import com.example.schedules.undercomment.dto.requestdto.UnderCommentUpdateRequestDto;
import com.example.schedules.undercomment.dto.responsedto.UnderCommentResponseDto;
import com.example.schedules.undercomment.dto.responsedto.UnderCommentWithCommentResponseDto;
import com.example.schedules.undercomment.entity.UnderComment;
import com.example.schedules.undercomment.repository.UnderCommentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnderCommentService {

	private final UnderCommentRepository underCommentRepository;
	private final ScheduleRepository scheduleRepository;
	private final CommentRepository commentRepository;

	@Transactional
	public UnderCommentResponseDto registerUnderComment(
		Long scheduleId,
		Long commentId,
		UnderCommentRequestDto underCommentRequestDto) {

		getScheduleId(scheduleId);

		Comment comment = getCommentId(commentId);

		Long commentCount = underCommentRepository.countUnderCommentByComment(comment);

		UnderComment underComment = UnderComment.builder()
			.writerId(underCommentRequestDto.getWriterId())
			.content(underCommentRequestDto.getContent())
			.comment(comment)
			.build();

		UnderComment savedUnderComment = underCommentRepository.save(underComment);

		return UnderCommentResponseDto.from(savedUnderComment);
	}

	@Transactional
	public UnderCommentResponseDto updateUnderComment(
		Long scheduleId,
		Long commentId,
		Long id,
		UnderCommentUpdateRequestDto underCommentUpdateRequestDto) {

		getScheduleId(scheduleId);

		getCommentId(commentId);

		UnderComment findByIdUnderComment = underCommentRepository.findByIdOrElseThrow(id);

		if(!findByIdUnderComment.getComment().getSchedule().getId().equals(scheduleId)){
			throw new CustomException(ErrorCode.SCHEDULE_NOT_EQUAL);
		}

		if(!findByIdUnderComment.getComment().getId().equals(commentId)){
			throw new CustomException(ErrorCode.COMMENT_NOT_EQUAL);
		}

		findByIdUnderComment.updateUnderComment(underCommentUpdateRequestDto);

		return UnderCommentResponseDto.from(findByIdUnderComment);
	}

	public UnderCommentWithCommentResponseDto findByIdUnderCommentWithComment(
		Long scheduleId,
		Long commentId,
		Long id) {

		getScheduleId(scheduleId);

		Comment comment = getCommentId(commentId);

		UnderComment findByIdUnderComment = underCommentRepository.findByIdOrElseThrow(id);

		if(!findByIdUnderComment.getComment().getSchedule().getId().equals(scheduleId)){
			throw new CustomException(ErrorCode.SCHEDULE_NOT_EQUAL);
		}

		if(!findByIdUnderComment.getComment().getId().equals(commentId)){
			throw new CustomException(ErrorCode.COMMENT_NOT_EQUAL);
		}

		CommentResponseDto commentResponseDto = new CommentResponseDto(
			comment.getId(),
			comment.getSchedule().getId(),
			comment.getWriterId(),
			comment.getContent(),
			comment.getCreatedAt(),
			comment.getUpdatedAt());

		List<UnderComment> underComments = underCommentRepository.findAllByCommentId(commentId);

		List<UnderCommentResponseDto> underCommentResponseDtos = underComments.stream()
			.map(UnderCommentResponseDto::from)
			.toList();

		return UnderCommentWithCommentResponseDto.from(commentResponseDto, underCommentResponseDtos);
	}

	public Schedule getScheduleId(Long scheduleId) {

		Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

		return schedule;
	}

	public Comment getCommentId(Long commentId) {

		Comment comment = commentRepository.findByIdOrElseThrow(commentId);

		return comment;
	}
}
