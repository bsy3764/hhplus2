package com.lecture.architecture.reservation.infra;

import com.lecture.architecture.reservation.domain.Reservation;
import com.lecture.architecture.reservation.domain.ReservationStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepository {

    private final JpaReservationRepository repository;

    @Override
    public Optional<Reservation> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Reservation> findByStudentId(String studentId) {
        return repository.findByStudentId(studentId);
    }

    @Override
    public Optional<Reservation> findByLectureId(long lectureId) {
        return repository.findByLectureId(lectureId);
    }

    @Override
    public List<Reservation> findByDate(LocalDateTime from, LocalDateTime to) {
        return repository.findByDateTimeBetween(from, to);
    }

    @Override
    public List<Reservation> findByStatus(ReservationStatus reservationStatus) {
        return repository.findByStatus(reservationStatus);
    }

    @Override
    public List<Reservation> findByStudentIdNStatus(String studentId, ReservationStatus reservationStatus) {
        return repository.findByStudentIdAndStatus(studentId, reservationStatus);
    }

    @Override
    public List<Reservation> findByDateNStatus(LocalDateTime dateTime, ReservationStatus reservationStatus) {
        return repository.findByDateTimeAndStatus(dateTime, reservationStatus);
    }

    @Override
    public void registReservation(long lectureId, String studentId){
        Reservation reservation = new Reservation(null, studentId, lectureId, LocalDateTime.now(), ReservationStatus.SUCCESS);
        repository.save(reservation);
    }

    public void save(Reservation reservation) {
        repository.save(reservation);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
