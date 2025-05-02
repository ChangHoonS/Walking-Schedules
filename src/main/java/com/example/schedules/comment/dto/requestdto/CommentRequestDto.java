package com.example.schedules.comment.dto.requestdto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentRequestDto {

	private final String writerId;

	private final String content;

}
