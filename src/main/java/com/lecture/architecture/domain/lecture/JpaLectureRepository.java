package com.lecture.architecture.domain.lecture;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface JpaLectureRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> findByTitleLike(String title);

    List<Lecture> findByInstructorLike(String instructor);

    List<Lecture> findByDateTimeBetween(LocalDateTime from, LocalDateTime to);

    List<Lecture> findByPriceLessThanEqual(int age);

    List<Lecture> findByStudentCountLessThanEqual(int studentCount);

    List<Lecture> findByStatus(LectureStatus lectureStatus);
}
