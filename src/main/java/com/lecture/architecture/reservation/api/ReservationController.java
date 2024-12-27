package com.lecture.architecture.reservation.api;

import com.lecture.architecture.global.LectureReservationFacade;
import com.lecture.architecture.reservation.dto.ReservationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final LectureReservationFacade service;

    @GetMapping("/{studentId}")
    public List<ReservationDto> getReservationByStudentId(@PathVariable String studentId) {
        List<ReservationDto> reservations = service.getReservationByStudentId(studentId);
        return reservations;
    }

    @PostMapping("/regist")
    public ReservationDto registReservation(@PathVariable long lectureId, @PathVariable String studentId) {
        ReservationDto reservationDto = service.requestReservation(lectureId, studentId);
        return reservationDto;
    }
}
