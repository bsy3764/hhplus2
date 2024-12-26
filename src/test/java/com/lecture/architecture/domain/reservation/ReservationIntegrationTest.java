package com.lecture.architecture.domain.reservation;

import com.lecture.architecture.reservation.domain.Reservation;
import com.lecture.architecture.reservation.domain.ReservationService;
import com.lecture.architecture.reservation.domain.ReservationStatus;
import com.lecture.architecture.reservation.infra.ReservationRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ReservationIntegrationTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    ReservationService service;

    @Autowired
    ReservationRepositoryImpl repository;

    private Reservation createReservation() {
        return Reservation.builder()
                .id(1L)
                .lectureId(1)
                .studentId("test")
                .status(ReservationStatus.SUCCESS)
                .build();
    }

    @BeforeEach
    void initDataInsert() {
        repository.save(new Reservation(null, "tester1", 1L,
                LocalDateTime.of(2024, 12, 27, 10, 0), ReservationStatus.SUCCESS));
        repository.save(new Reservation(null, "tester2", 2L,
                LocalDateTime.of(2024, 12, 28, 14, 0), ReservationStatus.SUCCESS));
    }

    @AfterEach
    void clear() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("신청한 강의는 예약내역을 저쟝해야 함")
    void saveReservation() {
        repository.save(new Reservation(null, "tester3", 1L, LocalDateTime.now(), ReservationStatus.SUCCESS));

        long id = 1L;
        Optional<Reservation> result = service.findById(id);
        Optional<Reservation> answer = repository.findById(id);

        if (result.isPresent()) {
            log.info("Reservation StudentId: {}", result.get().getStudentId());
            assertThat(result.get().getStudentId()).isEqualTo(answer.get().getStudentId());
        } else {

        }

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
        String studentId = "tester1";
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
        Optional<Reservation> answer = repository.findByLectureId(lectureId);
    }

    @Test
    @DisplayName("예약일로 예약 목록을 확인")
    void findByDateRange() {
        // given
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = LocalDateTime.now();
        Reservation reservation = createReservation();

        // when
        List<Reservation> result = service.findByDate(from, to);

        // then
        List<Reservation> answer = repository.findByDate(from, to);
    }

    @Test
    @DisplayName("예약일로 예약 목록을 확인")
    void findByDate() {
        // given
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime after = dateTime.plusDays(7);
        Reservation reservation = createReservation();

        // when
        List<Reservation> result = service.findByDate(dateTime);

        // then
        List<Reservation> answer = repository.findByDate(dateTime, after);
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
    @DisplayName("예약일 + 예약 상태로 예약 목록을 확인")
    void findByDateNStatus() {
        // given
        LocalDateTime dateTime = LocalDateTime.now();
        Reservation reservation = createReservation();

        // when
        List<Reservation> result = service.findByDateNStatus(dateTime, ReservationStatus.SUCCESS);

        // then
        List<Reservation> answer = repository.findByDateNStatus(dateTime, ReservationStatus.SUCCESS);
    }

}
