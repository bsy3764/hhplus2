package com.lecture.architecture.domain.lecture;

import com.lecture.architecture.lecture.domain.Lecture;
import com.lecture.architecture.lecture.domain.LectureService;
import com.lecture.architecture.lecture.domain.LectureStatus;
import com.lecture.architecture.lecture.infra.LectureRepositoryImpl;
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
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

//@Transactional
@SpringBootTest
public class LectureIntegrationTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
//    Lecture lecture;

    @Autowired
    LectureService service;

    @Autowired
    LectureRepositoryImpl repository;

    LocalDateTime time = LocalDateTime.now().minusDays(1);

    private Lecture createLectureBuilder() {
        return Lecture.builder()
                .id(1L)
                .title("주식 왕초보")
                .instructor("홍길동")
                .dateTime(time)
                .price(1000)
                .studentCount(new AtomicInteger(0))
                .status(LectureStatus.OPEN)
                .build();
    }

    @BeforeEach
    void initDataInsert() {
        repository.save(new Lecture(null, "Introduction to Java", "John Doe",
                LocalDateTime.of(2024, 12, 27, 10, 0), 20000, new AtomicInteger(20), LectureStatus.OPEN));
        repository.save(new Lecture(null, "Spring Boot Basics", "Jane Smith",
                LocalDateTime.of(2024, 12, 28, 14, 0), 15000, new AtomicInteger(10), LectureStatus.OPEN));
    }

    @AfterEach
    public void cleanup() {
        repository.deleteAll();
    }

    @Test
//    @Transactional
    @DisplayName("강의 ID로 검색하여 강의 가져오기")
    void getLectureByID() {
        // given
        long id = 1L;

        // when
        Optional<Lecture> optionalResult = service.findById(id);
        log.info("optionalLecture isPresent: {}", optionalResult.isPresent());
        Lecture result = null;
        if (optionalResult.isPresent()) {
            result = optionalResult.get();
        }

        // then
        Optional<Lecture> optionalAnswer = repository.findByID(id);
        Lecture answer = null;
        if (optionalAnswer.isPresent()) {
            answer = optionalAnswer.get();
        }

        assertThat(result.getId()).isEqualTo(answer.getId());
        assertThat(result.getTitle()).isEqualTo(answer.getTitle());
    }

    @Test
    @DisplayName("강의 제목을 like (%~~%) 검색하여 강의 목록 가져오기")
    void getLectureByTitle() {
        // given
        String title = "Introduction to Java";

        // when
        List<Lecture> results = service.findByTitle(title);

        // then
        List<Lecture> answer = repository.findByTitle(title);

        log.info("first Lecture title: {}", results.stream().findFirst().get().getTitle());
        assertThat(results.size()).isEqualTo(answer.size());
        assertThat(results.stream().findFirst().get().getTitle()).isEqualTo(answer.stream().findFirst().get().getTitle());
    }

    @Test
    @DisplayName("강사이름으로 강의 목록 가져오기")
    void getLectureByInstructor() {
        // given
        String instructor = "sdf";
        Lecture lecture = createLectureBuilder();

        // when
        List<Lecture> results = service.findByInstructor(instructor);

        // then
        List<Lecture> answer = repository.findByInstructor(instructor);
    }

    @Test
    @DisplayName("강의날짜로 강의 목록 가져오기")
    void getLectureByDateRange() {
        // given
        LocalDateTime from = time.minusDays(3L);
        LocalDateTime to = time.plusDays(3L);
        Lecture lecture = createLectureBuilder();

        // when
        List<Lecture> results = service.findByDateTime(from, to);

        // then
        List<Lecture> answer = repository.findByDateTime(from, to);
    }

    @Test
    @DisplayName("강의날짜로 강의 목록 가져오기")
    void getLectureByDate() {
        // given
        LocalDateTime to = time.plusMonths(6L);
        Lecture lecture = createLectureBuilder();

        // when
        List<Lecture> results = service.findByDateTime(time);

        // then
        List<Lecture> answer = repository.findByDateTime(time, to);
    }

    @Test
    @DisplayName("강의 가격으로 강의 목록 가져오기")
    void getLectureByPrice() {
        // given
        int price = 30000;
        Lecture lecture = createLectureBuilder();

        // when
        List<Lecture> results = service.findByPrice(price);

        // then
        List<Lecture> answer = repository.findByPrice(price);
    }

    @Test
    @DisplayName("신청한 수강생 수로 강의 목록 가져오기")
    void getLectureByStudentCount() {
        // given
        int studentCount = 25;
        Lecture lecture = createLectureBuilder();

        // when
        List<Lecture> results = service.findByStudentCount(studentCount);

        // then
        List<Lecture> answer = repository.findByStudentCount(studentCount);
    }

    @Test
    @DisplayName("강의 상태로 강의 목록 가져오기")
    void getLectureByStatus() {
        // given
        Lecture lecture = createLectureBuilder();

        // when
        List<Lecture> results = service.findByStatus(LectureStatus.OPEN);

        // then
        List<Lecture> answer = repository.findByStatus(LectureStatus.OPEN);
    }

    @Test
    @DisplayName("강의를 신청하면 학생수가 증가함")
    void addStudentCount() {
        long id = 1L;
        boolean result = service.addStudentCount(id);
        assertThat(result).isTrue();
    }
}
