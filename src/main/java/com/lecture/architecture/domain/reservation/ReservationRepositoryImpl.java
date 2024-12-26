package com.lecture.architecture.domain.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepository {
    @Override
    public Optional<Reservation> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Reservation> findByStudentId(String studentId) {
        return List.of();
    }

    @Override
    public Optional<Reservation> findByLectureId(long lectureId) {
        return Optional.empty();
    }

    @Override
    public List<Reservation> findByDate(LocalDateTime from, LocalDateTime to) {
        return List.of();
    }

    @Override
    public List<Reservation> findByStatus(ReservationStatus reservationStatus) {
        return List.of();
    }

    @Override
    public List<Reservation> findByStudentIdNStatus(String studentId, ReservationStatus reservationStatus) {
        return List.of();
    }

    @Override
    public List<Reservation> findByDateNStatus(LocalDateTime dateTime, ReservationStatus reservationStatus) {
        return List.of();
    }
//
//    private final JpaReservationRepository repository;
//
//    @Override
//    public Optional<Reservation> findById(long id) {
//        return repository.findById(id);
//    }
//
//    @Override
//    public List<Reservation> findByStudentId(String studentId) {
//        return repository.findByStudentId(studentId);
//    }
//
//    @Override
//    public Optional<Reservation> findByLectureId(long lectureId) {
//        return repository.findByLectureId(lectureId);
//    }
//
//    @Override
//    public List<Reservation> findByDate(LocalDateTime from, LocalDateTime to) {
//        return repository.findByDateTimeBetween(from, to);
//    }
//
//    @Override
//    public List<Reservation> findByStatus(ReservationStatus reservationStatus) {
//        return repository.findByStatus(reservationStatus);
//    }
//
//    @Override
//    public List<Reservation> findByStudentIdNStatus(String studentId, ReservationStatus reservationStatus) {
//        return repository.findByStudentIdAndStatus(studentId, reservationStatus);
//    }
//
//    @Override
//    public List<Reservation> findByDateNStatus(LocalDateTime dateTime, ReservationStatus reservationStatus) {
//        return repository.findByDateAndStatus(dateTime, reservationStatus);
//    }
}
