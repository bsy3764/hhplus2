package com.lecture.architecture.global;

import com.lecture.architecture.lecture.domain.LectureService;
import com.lecture.architecture.reservation.domain.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureReservationFacade {

    private final LectureService lectureService;
    private final ReservationService reservationService;


}
