package com.example.schedules.comment.dto.responsedto;

import java.time.LocalDateTime;

import com.example.schedules.comment.entity.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentGetResponseDto {

	private final Long id;

	private final Long scheduleId;

	private final String writerId;

	private final String content;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private final LocalDateTime createdAt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private final LocalDateTime updatedAt;

	@Builder
	public CommentGetResponseDto(
		Long id,
		Long scheduleId,
		String writerId,
		String content,
		LocalDateTime createdAt,
		LocalDateTime updatedAt) {
		this.id = id;
		this.scheduleId = scheduleId;
		this.writerId = writerId;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public static CommentGetResponseDto from(Comment comment) {
		return CommentGetResponseDto.builder()
			.id(comment.getId())
			.scheduleId(comment.getSchedule().getId())
			.writerId(comment.getWriterId())
			.content(comment.getContent())
			.createdAt(comment.getCreatedAt())
			.updatedAt(comment.getUpdatedAt())
			.build();
	}
}
