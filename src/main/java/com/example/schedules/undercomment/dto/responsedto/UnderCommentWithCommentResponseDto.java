package com.example.schedules.undercomment.dto.responsedto;

import java.util.List;

import com.example.schedules.comment.dto.responsedto.CommentResponseDto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UnderCommentWithCommentResponseDto {

	private final CommentResponseDto commentResponseDto;

	private final List<UnderCommentResponseDto> underCommentResponseDtos;

	@Builder
	public UnderCommentWithCommentResponseDto(CommentResponseDto commentResponseDto,
		List<UnderCommentResponseDto> underCommentResponseDtos) {
		this.commentResponseDto = commentResponseDto;
		this.underCommentResponseDtos = underCommentResponseDtos;
	}

	public static UnderCommentWithCommentResponseDto from(CommentResponseDto commentResponseDto,
		List<UnderCommentResponseDto> underCommentResponseDtos){
		return UnderCommentWithCommentResponseDto.builder()
			.commentResponseDto(commentResponseDto)
			.underCommentResponseDtos(underCommentResponseDtos)
			.build();
	}

}
