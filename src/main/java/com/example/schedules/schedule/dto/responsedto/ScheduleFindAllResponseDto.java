package com.example.schedules.schedule.dto.responsedto;

import com.example.schedules.schedule.entity.Schedule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleFindAllResponseDto {

	private final Long id;

	private final String writerId;

	private final String title;

	private final String content;

	private Long commentCounts;

	@Builder
	public ScheduleFindAllResponseDto(Long id, String writerId, String title, String content) {
		this.id = id;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
	}

	public static ScheduleFindAllResponseDto from(Schedule schedule) {
		return ScheduleFindAllResponseDto.builder()
			.id(schedule.getId())
			.writerId(schedule.getWriterId())
			.title(schedule.getTitle())
			.content(schedule.getContent())
			.build();
	}
}
