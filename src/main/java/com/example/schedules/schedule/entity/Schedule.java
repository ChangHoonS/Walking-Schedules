package com.example.schedules.schedule.entity;

import com.example.schedules.common.entity.BaseEntity;
import com.example.schedules.schedule.dto.requestdto.ScheduleUpdateRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String writerId;

	private String title;

	private String content;

	@Builder
	public Schedule(String writerId, String title, String content) {
		this.writerId = writerId;
		this.title = title;
		this.content = content;
	}

	public void updateSchedule(ScheduleUpdateRequestDto scheduleUpdateRequestDto) {
		this.title = scheduleUpdateRequestDto.getTitle();
		this.content = scheduleUpdateRequestDto.getContent();
	}

}
