package com.example.schedules.comment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.schedules.comment.dto.requestdto.CommentRequestDto;
import com.example.schedules.comment.dto.requestdto.CommentUpdateRequestDto;
import com.example.schedules.comment.dto.responsedto.CommentGetResponseDto;
import com.example.schedules.comment.dto.responsedto.CommentResponseDto;
import com.example.schedules.comment.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/schedules/{scheduleId}/comments")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@PostMapping
	public ResponseEntity<CommentResponseDto> registerComment(
		@PathVariable Long scheduleId,
		@RequestBody CommentRequestDto commentRequestDto) {

		CommentResponseDto commentResponseDto = commentService.registerComment(scheduleId, commentRequestDto);

		return new ResponseEntity<>(commentResponseDto, HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<CommentResponseDto> updateComment(
		@PathVariable Long scheduleId,
		@PathVariable Long id,
		@RequestBody CommentUpdateRequestDto commentUpdateRequestDto) {

		CommentResponseDto commentResponseDto = commentService.updateComment(scheduleId, id, commentUpdateRequestDto);

		return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CommentGetResponseDto>> findAll(@PathVariable Long scheduleId) {

		List<CommentGetResponseDto> findAllComment = commentService.findAll(scheduleId);

		return new ResponseEntity<>(findAllComment, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CommentGetResponseDto> findById(
		@PathVariable Long scheduleId,
		@PathVariable Long id) {

		CommentGetResponseDto commentGetResponseDto = commentService.findComment(scheduleId, id);

		return new ResponseEntity<>(commentGetResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(
		@PathVariable Long scheduleId,
		@PathVariable Long id) {

		commentService.delete(scheduleId, id);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
