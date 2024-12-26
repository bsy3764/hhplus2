package com.lecture.architecture.reservation.api;

import com.lecture.architecture.lecture.domain.Lecture;
import com.lecture.architecture.lecture.domain.LectureService;
import com.lecture.architecture.reservation.domain.Reservation;
import com.lecture.architecture.reservation.domain.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService service;

    @GetMapping
    public Reservation searchLectures() {
        Optional<Reservation> optionalReservation = service.findById(1L);
        return optionalReservation.get();
    }
}
