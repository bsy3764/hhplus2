package com.lecture.architecture.lecture.infra;

import com.lecture.architecture.lecture.domain.Lecture;
import com.lecture.architecture.lecture.domain.LectureStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LectureRepository {

    Optional<Lecture> findByID(long id);

    List<Lecture> findByTitle(String title);

    List<Lecture> findByInstructor(String instructor);

    List<Lecture> findByDateTime(LocalDateTime from, LocalDateTime to);

    List<Lecture> findByPrice(int price);

    List<Lecture> findByStudentCount(int studentCount);

    List<Lecture> findByStatus(LectureStatus lectureStatus);

    void save(Lecture lecture);
}
