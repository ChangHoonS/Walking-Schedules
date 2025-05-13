package com.example.schedules.common.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

	SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "일정이 존재하지 않습니다."),
	SCHEDULE_NOT_EQUAL(HttpStatus.BAD_REQUEST, "일정이 일치하지 않습니다."),

	COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "댓글이 존재하지 않습니다."),
	COMMENT_NOT_EQUAL(HttpStatus.BAD_REQUEST, "댓글이 일치하지 않습니다"),

	UNDER_COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "대댓글이 존재하지 않습니다."),
	UNDER_COMMENT_ONLY_ONE(HttpStatus.NOT_ACCEPTABLE, "대댓글은 하나만 작성할 수 있습니다.");

	private final HttpStatus httpStatus;
	private final String message;

	ErrorCode(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return httpStatus;
	}

	public String getMessage() {
		return message;
	}
}
