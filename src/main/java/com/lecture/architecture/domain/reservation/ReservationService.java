package com.lecture.architecture.domain.reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Optional<Reservation> findById(long id);

    List<Reservation> findByStudentId(String studentId);

    Optional<Reservation> findByLectureId(long lectureId);

    List<Reservation> findByInstructor(String instructor);

    List<Reservation> findByStatus(ReservationStatus reservationStatus);

    List<Reservation> findByStudentIdNStatus(String studentId, ReservationStatus reservationStatus);

    List<Reservation> findByInstructorNStatus(String instructor, ReservationStatus reservationStatus);
}
