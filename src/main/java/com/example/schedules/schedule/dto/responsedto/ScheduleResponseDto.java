package com.example.schedules.schedule.dto.responsedto;

import java.time.LocalDateTime;

import com.example.schedules.schedule.entity.Schedule;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

	private final Long id;

	private final String writerId;

	private final String title;

	private final String content;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private final LocalDateTime createdAt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private final LocalDateTime updatedAt;

	@Builder
	public ScheduleResponseDto(Long id, String writerId, String title, String content,
		LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public static ScheduleResponseDto from(Schedule schedule) {
		return ScheduleResponseDto.builder()
			.id(schedule.getId())
			.writerId(schedule.getWriterId())
			.title(schedule.getTitle())
			.content(schedule.getContent())
			.createdAt(schedule.getCreatedAt())
			.updatedAt(schedule.getUpdatedAt())
			.build();
	}
}
