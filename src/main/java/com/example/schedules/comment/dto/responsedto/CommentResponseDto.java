package com.example.schedules.comment.dto.responsedto;

import com.example.schedules.comment.entity.Comment;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentResponseDto {

	private final Long id;

	private final Long scheduleId;

	private final String writerId;

	private final String content;

	@Builder
	public CommentResponseDto(Long id, Long scheduleId, String writerId, String content) {
		this.id = id;
		this.scheduleId = scheduleId;
		this.writerId = writerId;
		this.content = content;
	}

	public static CommentResponseDto from(Comment comment) {
		return CommentResponseDto.builder()
			.id(comment.getId())
			.scheduleId(comment.getSchedule().getId())
			.writerId(comment.getWriterId())
			.content(comment.getContent())
			.build();
	}
}
