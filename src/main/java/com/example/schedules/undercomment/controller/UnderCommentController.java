package com.example.schedules.undercomment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.schedules.undercomment.dto.requestdto.UnderCommentRequestDto;
import com.example.schedules.undercomment.dto.requestdto.UnderCommentUpdateRequestDto;
import com.example.schedules.undercomment.dto.responsedto.UnderCommentResponseDto;
import com.example.schedules.undercomment.dto.responsedto.UnderCommentWithCommentResponseDto;
import com.example.schedules.undercomment.repository.UnderCommentRepository;
import com.example.schedules.undercomment.service.UnderCommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/schedules/{scheduleId}/comments/{commentId}/undercomments")
@RequiredArgsConstructor
public class UnderCommentController {

	private final UnderCommentService underCommentService;
	private final UnderCommentRepository underCommentRepository;

	@PostMapping
	public ResponseEntity<UnderCommentResponseDto> registerUnderComment(
		@Valid
		@PathVariable Long scheduleId,
		@PathVariable Long commentId,
		@RequestBody UnderCommentRequestDto underCommentRequestDto) {

		UnderCommentResponseDto underCommentResponseDto = underCommentService.registerUnderComment(scheduleId,
			commentId, underCommentRequestDto);

		return new ResponseEntity<>(underCommentResponseDto, HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<UnderCommentResponseDto> updateUnderComment(
		@Valid
		@PathVariable Long scheduleId,
		@PathVariable Long commentId,
		@PathVariable Long id,
		@RequestBody UnderCommentUpdateRequestDto underCommentUpdateRequestDto) {

		UnderCommentResponseDto underCommentResponseDto = underCommentService.updateUnderComment(scheduleId, commentId, id, underCommentUpdateRequestDto);

		return new ResponseEntity<>(underCommentResponseDto, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UnderCommentWithCommentResponseDto> findByIdUnderCommentWithComment(
		@PathVariable Long scheduleId,
		@PathVariable Long commentId,
		@PathVariable Long id) {

		UnderCommentWithCommentResponseDto underCommentWithCommentResponseDto = underCommentService.findByIdUnderCommentWithComment(
			scheduleId, commentId, id);

		return new ResponseEntity<>(underCommentWithCommentResponseDto, HttpStatus.OK);
	}

}
