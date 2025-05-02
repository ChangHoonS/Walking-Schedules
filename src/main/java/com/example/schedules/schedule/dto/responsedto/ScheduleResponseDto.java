package com.example.schedules.schedule.dto.responsedto;

import com.example.schedules.schedule.entity.Schedule;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

	private final Long id;

	private final String writerId;

	private final String title;

	private final String content;

	@Builder
	public ScheduleResponseDto(Long id, String writerId, String title, String content) {
		this.id = id;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
	}

	public static ScheduleResponseDto from(Schedule schedule) {
		return ScheduleResponseDto.builder()
			.id(schedule.getId())
			.writerId(schedule.getWriterId())
			.title(schedule.getTitle())
			.content(schedule.getContent())
			.build();
	}
}
