package com.lecture.architecture.reservation.api;

import com.lecture.architecture.global.LectureReservationFacade;
import com.lecture.architecture.reservation.dto.ReservationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final LectureReservationFacade service;

    @GetMapping
    public List<ReservationDto> getReservationByStudentId() {
        List<ReservationDto> reservations = service.getReservationByStudentId("test1");
        return reservations;
    }
}
