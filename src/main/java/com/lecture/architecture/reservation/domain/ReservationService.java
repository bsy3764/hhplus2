package com.lecture.architecture.reservation.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Optional<Reservation> findById(long id);

    List<Reservation> findByStudentId(String studentId);

    Optional<Reservation> findByLectureId(long lectureId);

    List<Reservation> findByDate(LocalDateTime from, LocalDateTime to);

    List<Reservation> findByDate(LocalDateTime dateTime);

    List<Reservation> findByStatus(ReservationStatus reservationStatus);

    List<Reservation> findByStudentIdNStatus(String studentId, ReservationStatus reservationStatus);

    List<Reservation> findByDateNStatus(LocalDateTime dateTime, ReservationStatus reservationStatus);
}
