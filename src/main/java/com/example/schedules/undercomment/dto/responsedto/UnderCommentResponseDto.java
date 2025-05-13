package com.example.schedules.undercomment.dto.responsedto;

import java.time.LocalDateTime;

import com.example.schedules.undercomment.entity.UnderComment;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UnderCommentResponseDto {

	private final Long id;

	private final Long commentId;

	private final String writerId;

	private final String content;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private final LocalDateTime createdAt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private final LocalDateTime updatedAt;

	@Builder
	public UnderCommentResponseDto(
		Long id,
		String writerId,
		String content,
		Long commentId,
		LocalDateTime createdAt,
		LocalDateTime updatedAt) {
		this.id = id;
		this.writerId = writerId;
		this.content = content;
		this.commentId = commentId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public static UnderCommentResponseDto from(UnderComment underComment) {
		return UnderCommentResponseDto.builder()
			.id(underComment.getId())
			.commentId(underComment.getComment().getId())
			.writerId(underComment.getWriterId())
			.content(underComment.getContent())
			.createdAt(underComment.getCreatedAt())
			.updatedAt(underComment.getUpdatedAt())
			.build();
	}
}
