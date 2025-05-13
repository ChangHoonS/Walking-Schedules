package com.example.schedules.schedule.dto.responsedto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.schedules.comment.dto.responsedto.CommentGetResponseDto;
import com.example.schedules.schedule.entity.Schedule;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ScheduleWithCommentResponseDto {

	private final Long id;

	private final String writerId;

	private final String title;

	private final String content;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private final LocalDateTime createdAt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private final LocalDateTime updatedAt;

	private final List<CommentGetResponseDto> commentGetResponseDtos;

	@Builder
	public ScheduleWithCommentResponseDto(
		Long id,
		String writerId,
		String title,
		String content,
		LocalDateTime createdAt,
		LocalDateTime updatedAt,
		List<CommentGetResponseDto> commentGetResponseDtos) {
		this.id = id;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.commentGetResponseDtos = commentGetResponseDtos;
	}

	public static ScheduleWithCommentResponseDto from(Schedule schedule, List<CommentGetResponseDto> commentGetResponseDtos) {
		return ScheduleWithCommentResponseDto.builder()
			.id(schedule.getId())
			.writerId(schedule.getWriterId())
			.title(schedule.getTitle())
			.content(schedule.getContent())
			.createdAt(schedule.getCreatedAt())
			.updatedAt(schedule.getUpdatedAt())
			.commentGetResponseDtos(commentGetResponseDtos)
			.build();
	}
}
