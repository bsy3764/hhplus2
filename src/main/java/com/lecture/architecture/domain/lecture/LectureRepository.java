package com.lecture.architecture.domain.lecture;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LectureRepository {

    Optional<Lecture> findByID(long id);

    List<Lecture> findByTitle(String title);

    List<Lecture> findByInstructor(String instructor);

    List<Lecture> findByDateTime(LocalDateTime from, LocalDateTime to);

    List<Lecture> findByDateTime(LocalDateTime to);

    List<Lecture> findByPrice(int price);

    List<Lecture> findByStudentCount(int studentCount);

    List<Lecture> findByStatus(LectureStatus lectureStatus);
}
