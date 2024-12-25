package com.lecture.architecture.domain.reservation;

import com.lecture.architecture.domain.reservation.Reservation;
import com.lecture.architecture.domain.reservation.ReservationService;
import com.lecture.architecture.domain.reservation.ReservationStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ReservationIntegrationTest {

    @Autowired
    ReservationService service;

    @Autowired
    ReservationRepository repository;

    private Reservation createReservation() {
        return Reservation.builder()
                .id(1L)
                .lectureId(1)
                .studentId("test")
                .status(ReservationStatus.SUCCESS)
                .build();
    }

    @Test
    @DisplayName("예약 ID로 예약을 확인")
    void findById() {
        // given
        long id = 1L;
        Reservation reservation = createReservation();

        // when
        Optional<Reservation> result = service.findById(id);

        // then
        Optional<Reservation> answer = repository.findById(id);
    }

    @Test
    @DisplayName("학생 ID로 예약 목록을 확인")
    void findByStudentId() {
        // given
        String studentId = "";
        Reservation reservation = createReservation();

        // when
        List<Reservation> result = service.findByStudentId(studentId);

        // then
        List<Reservation> answer = repository.findByStudentId(studentId);
    }

    @Test
    @DisplayName("강의 ID로 예약 목록을 확인")
    void findByLectureId() {
        // given
        long lectureId = 1L;
        Reservation reservation = createReservation();

        // when
        Optional<Reservation> result = service.findByLectureId(lectureId);

        // then
        List<Reservation> answer = repository.findByLectureId(lectureId);
    }

    @Test
    @DisplayName("강사로 예약 목록을 확인")
    void findByInstructor() {
        // given
        String instructor = "";
        Reservation reservation = createReservation();

        // when
        List<Reservation> result = service.findByInstructor(instructor);

        // then
        List<Reservation> answer = repository.findByInstructor(instructor);
    }

    @Test
    @DisplayName("예약 상태로 예약 목록을 확인")
    void findByStatus() {
        // given
        Reservation reservation = createReservation();

        // when
        List<Reservation> result = service.findByStatus(ReservationStatus.SUCCESS);

        // then
        List<Reservation> answer = repository.findByStatus(ReservationStatus.SUCCESS);
    }

    @Test
    @DisplayName("학생 ID + 예약 상태로 예약 목록을 확인")
    void findByStudentIdNStatus() {
        // given
        String studentId = "";
        Reservation reservation = createReservation();

        // when
        List<Reservation> result = service.findByStudentIdNStatus(studentId, ReservationStatus.SUCCESS);

        // then
        List<Reservation> answer = repository.findByStudentIdNStatus(studentId, ReservationStatus.SUCCESS);
    }

    @Test
    @DisplayName("강사명 + 예약 상태로 예약 목록을 확인")
    void findByLectureIdNStatus() {
        // given
        String instructor = "";
        Reservation reservation = createReservation();

        // when
        List<Reservation> result = service.findByInstructorNStatus(instructor, ReservationStatus.SUCCESS);

        // then
        List<Reservation> answer = repository.findByInstructorNStatus(instructor, ReservationStatus.SUCCESS);
    }

}
