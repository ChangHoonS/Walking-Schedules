package com.example.schedules.comment.dto.requestdto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentRequestDto {

	@NotBlank(message = "작성자는 필수입니다.")
	private final String writerId;

	@NotBlank(message = "내용은 필수입니다.")
	private final String content;

}
