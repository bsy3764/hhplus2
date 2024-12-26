package com.lecture.architecture.reservation.domain;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{
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
    public List<Reservation> findByDate(LocalDateTime dateTime) {
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
}
