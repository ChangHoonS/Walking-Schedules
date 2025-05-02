package com.example.schedules.comment.dto.responsedto;

import java.time.LocalDateTime;

import com.example.schedules.comment.entity.Comment;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentGetResponseDto {

	private final Long id;

	private final Long scheduleId;

	private final String writerId;

	private final String content;

	private final LocalDateTime createdAt;

	@Builder
	public CommentGetResponseDto(Long id, Long scheduleId, String writerId, String content, LocalDateTime createdAt) {
		this.id = id;
		this.scheduleId = scheduleId;
		this.writerId = writerId;
		this.content = content;
		this.createdAt = createdAt;
	}

	public static CommentGetResponseDto from(Comment comment) {
		return CommentGetResponseDto.builder()
			.id(comment.getId())
			.scheduleId(comment.getSchedule().getId())
			.writerId(comment.getWriterId())
			.content(comment.getContent())
			.createdAt(comment.getCreatedAt())
			.build();
	}
}
