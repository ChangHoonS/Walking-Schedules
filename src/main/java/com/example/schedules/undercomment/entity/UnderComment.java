package com.example.schedules.undercomment.entity;

import com.example.schedules.comment.entity.Comment;
import com.example.schedules.common.entity.BaseEntity;
import com.example.schedules.undercomment.dto.requestdto.UnderCommentUpdateRequestDto;

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
@Table(name = "under_comment")
@NoArgsConstructor
public class UnderComment extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String writerId;

	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comment_id")
	private Comment comment;

	@Builder
	public UnderComment(String writerId, String content, Comment comment) {
		this.writerId = writerId;
		this.content = content;
		this.comment = comment;
	}

	public void updateUnderComment(UnderCommentUpdateRequestDto underCommentUpdateRequestDto) {
		this.content = underCommentUpdateRequestDto.getContent();
	}
}
