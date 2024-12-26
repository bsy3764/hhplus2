package com.lecture.architecture.lecture.infra;

import com.lecture.architecture.lecture.domain.Lecture;
import com.lecture.architecture.lecture.domain.LectureStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LectureRepositoryImpl implements LectureRepository {

    private final JpaLectureRepository repository;

    @Override
    public Optional<Lecture> findByID(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Lecture> findByTitle(String title) {
        return repository.findByTitleLike(title);
    }

    @Override
    public List<Lecture> findByInstructor(String instructor) {
        return repository.findByInstructorLike(instructor);
    }

    @Override
    public List<Lecture> findByDateTime(LocalDateTime from, LocalDateTime to) {
        return repository.findByDateTimeBetween(from, to);
    }

    @Override
    public List<Lecture> findByPrice(int price) {
        return repository.findByPriceLessThanEqual(price);
    }

    @Override
    public List<Lecture> findByStudentCount(int studentCount) {
        return repository.findByStudentCountLessThanEqual(studentCount);
    }

    @Override
    public List<Lecture> findByStatus(LectureStatus lectureStatus) {
        return repository.findByStatus(lectureStatus);
    }

    public void save(Lecture lecture){
        repository.save(lecture);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
