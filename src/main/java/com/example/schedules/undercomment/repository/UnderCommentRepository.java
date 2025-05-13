package com.example.schedules.undercomment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schedules.comment.entity.Comment;
import com.example.schedules.common.exception.CustomException;
import com.example.schedules.common.exception.ErrorCode;
import com.example.schedules.undercomment.entity.UnderComment;

public interface UnderCommentRepository extends JpaRepository<UnderComment, Long> {

	default UnderComment findByIdOrElseThrow(Long id) {
		return findById(id)
			.orElseThrow(() -> new CustomException(ErrorCode.UNDER_COMMENT_NOT_FOUND));
	}

	Long countUnderCommentByComment(Comment comment);

	List<UnderComment> findAllByCommentId(Long commentId);
}
