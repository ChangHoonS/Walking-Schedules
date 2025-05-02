package com.example.schedules.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.schedules.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	default Comment findByIdOrElseThrow(Long id) {
		return findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));

	}
}
