package com.lecture.architecture.reservation.infra;

import com.lecture.architecture.reservation.domain.Reservation;
import com.lecture.architecture.reservation.domain.ReservationStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    Optional<Reservation> findById(long id);

    List<Reservation> findByStudentId(String studentId);

    Optional<Reservation> findByLectureId(long lectureId);

    List<Reservation> findByDate(LocalDateTime from, LocalDateTime to);

    List<Reservation> findByStatus(ReservationStatus reservationStatus);

    List<Reservation> findByStudentIdNStatus(String studentId, ReservationStatus reservationStatus);

    List<Reservation> findByDateNStatus(LocalDateTime dateTime, ReservationStatus reservationStatus);

    void registReservation(long lectureId, String studentId);
}
