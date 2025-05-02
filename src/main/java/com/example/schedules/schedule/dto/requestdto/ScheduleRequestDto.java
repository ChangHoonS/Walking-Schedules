package com.example.schedules.schedule.dto.requestdto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {

	private final String writerId;

	private final String title;

	private final String content;

}
