package com.lecture.architecture.reservation.infra;

import com.lecture.architecture.reservation.domain.Reservation;
import com.lecture.architecture.reservation.domain.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface JpaReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByStudentId(String studentId);

    Optional<Reservation> findByLectureId(long lectureId);

    List<Reservation> findByDateTimeBetween(LocalDateTime from, LocalDateTime to);

    List<Reservation> findByStatus(ReservationStatus reservationStatus);

    List<Reservation> findByStudentIdAndStatus(String studentId, ReservationStatus reservationStatus);

    List<Reservation> findByDateTimeAndStatus(LocalDateTime dateTime, ReservationStatus reservationStatus);
}
