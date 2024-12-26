package com.lecture.architecture.domain.lecture;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService{

    private final LectureRepository repository;

    @Override
    public Optional<Lecture> findById(long id) {
        return repository.findByID(id);
    }

    @Override
    public List<Lecture> findByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public List<Lecture> findByInstructor(String instructor) {
        return repository.findByInstructor(instructor);
    }

    @Override
    public List<Lecture> findByDateTime(LocalDateTime from, LocalDateTime to) {
//        Period diff = Period.between(from.toLocalDate(), to.toLocalDate());
//        int diffYears = diff.getYears();
//        int diffMonths = diff.getMonths();
//        int diffDays = diff.getDays();
//        if (diffYears > 1) {
//            throw new IllegalArgumentException("강의 조회기간은 최대 1년입니다.");
//        }
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneMonthBefore = now.minusMonths(1);
        LocalDateTime oneMonthAfter = now.plusMonths(1);
        boolean isWithinOneMonth = !from.isBefore(oneMonthBefore) && !from.isAfter(oneMonthAfter);
        if (!isWithinOneMonth) {
            throw new IllegalArgumentException("강의 조회 시작날짜는 현재로부터 전후 1개월까지 입니다.");
        }

        boolean isWithinOneYear = ChronoUnit.YEARS.between(from, to) <= 1;
        if (!isWithinOneYear){
            throw new IllegalArgumentException("강의 조회기간은 최대 1년입니다.");
        }
        return repository.findByDateTime(from, to);
    }

    @Override
    public List<Lecture> findByDateTime(LocalDateTime dateTime) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneWeekBefore = now.minusDays(7);
        LocalDateTime oneWeekAfter = now.plusDays(7);
        boolean isWithinOneWeek = !dateTime.isBefore(oneWeekBefore) && !dateTime.isAfter(oneWeekAfter);
        if (!isWithinOneWeek) {
            throw new IllegalArgumentException("강의 조회 시작날짜는 현재로부터 전후 7일까지 입니다.");
        }

        LocalDateTime endDateTime = dateTime.plusMonths(6L);
        return repository.findByDateTime(dateTime, endDateTime);
    }

    @Override
    public List<Lecture> findByPrice(int price) {
        return repository.findByPrice(price);
    }

    @Override
    public List<Lecture> findByStudentCount(int studentCount) {
        return repository.findByStudentCount(studentCount);
    }

    @Override
    public List<Lecture> findByStatus(LectureStatus lectureStatus) {
        return repository.findByStatus(lectureStatus);
    }
}
