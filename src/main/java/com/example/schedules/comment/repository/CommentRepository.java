package com.example.schedules.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schedules.comment.entity.Comment;
import com.example.schedules.common.exception.CustomException;
import com.example.schedules.common.exception.ErrorCode;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	default Comment findByIdOrElseThrow(Long id) {
		return findById(id)
			.orElseThrow(() -> new CustomException(ErrorCode.COMMENT_NOT_FOUND));
	}

	List<Comment> findAllByScheduleId(Long scheduleId);

}
