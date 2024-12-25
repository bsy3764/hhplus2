package com.lecture.architecture.domain.lecture;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LectureService {
    /**
     * 강의 ID로 강의 객체 찾기
     * @param id 강의 ID
     * @return
     */
    Optional<Lecture> findById(long id);

    List<Lecture> findByTitle(String title);

    List<Lecture> findByInstructor(String instructor);

    List<Lecture> findByDateTime(LocalDateTime from, LocalDateTime to);

    List<Lecture> findByDateTime(LocalDateTime to);

    List<Lecture> findByPrice(int price);

    List<Lecture> findByStudentCount(int studentCount);

    List<Lecture> findByStatus(LectureStatus lectureStatus);
}
