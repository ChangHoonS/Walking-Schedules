package com.example.schedules.schedule.controller;

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

import com.example.schedules.schedule.dto.requestdto.ScheduleRequestDto;
import com.example.schedules.schedule.dto.requestdto.ScheduleUpdateRequestDto;
import com.example.schedules.schedule.dto.responsedto.ScheduleResponseDto;
import com.example.schedules.schedule.service.ScheduleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScheduleController {

	private final ScheduleService scheduleService;

	@PostMapping("/schedules")
	public ResponseEntity<ScheduleResponseDto> registerSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {

		ScheduleResponseDto scheduleResponseDto = scheduleService.registerSchedule(scheduleRequestDto);

		return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
	}

	@PatchMapping("/schedules/{id}")
	public ResponseEntity<ScheduleResponseDto> updateSchedule(
		@PathVariable Long id,
		@RequestBody ScheduleUpdateRequestDto scheduleUpdateRequestDto) {

		ScheduleResponseDto scheduleResponseDto = scheduleService.updateSchedule(id, scheduleUpdateRequestDto);

		return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
	}

	@GetMapping("/schedules")
	public ResponseEntity<List<ScheduleResponseDto>> findAll() {

		List<ScheduleResponseDto> findAllSchedule = scheduleService.findAll();

		return new ResponseEntity<>(findAllSchedule, HttpStatus.OK);
	}

	@GetMapping("/schedules/{id}")
	public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {

		ScheduleResponseDto scheduleResponseDto = scheduleService.updateSchedule(id);

		return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/schedules/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		scheduleService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
