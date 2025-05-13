package com.example.schedules.undercomment.dto.requestdto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UnderCommentUpdateRequestDto {

	@NotBlank(message = "내용은 필수입니다.")
	private final String content;
}
