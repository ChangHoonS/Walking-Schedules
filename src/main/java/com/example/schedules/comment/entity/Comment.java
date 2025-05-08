package com.example.schedules.comment.entity;

import com.example.schedules.comment.dto.requestdto.CommentUpdateRequestDto;
import com.example.schedules.common.entity.BaseEntity;
import com.example.schedules.schedule.entity.Schedule;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String writerId;

	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;

	@Builder
	public Comment(String writerId, String content, Schedule schedule) {
		this.writerId = writerId;
		this.content = content;
		this.schedule = schedule;
	}

	public void updateComment(CommentUpdateRequestDto commentUpdateRequestDto) {
		this.content = commentUpdateRequestDto.getContent();
	}
}
