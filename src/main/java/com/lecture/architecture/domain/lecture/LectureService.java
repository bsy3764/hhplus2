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

    /**
     * 강의 제목으로 강의 객체 찾기
     * @param title 강의 제목
     * @return
     */
    List<Lecture> findByTitle(String title);

    /**
     * 강사명으로 해당 강사가 강의한 강의 리스트 찾기
     * @param instructor 강사명
     * @return
     */
    List<Lecture> findByInstructor(String instructor);

    /**
     * 강의 날짜를 범위로 강의 리스트 찾기(최대 1년)
     * @param from 검색 시작날짜(현재로 부터 전후 1개월까지)
     * @param to 검색 종료날짜
     * @return
     */
    List<Lecture> findByDateTime(LocalDateTime from, LocalDateTime to);

    /**
     * 강의 날짜를 특정 시점 이후로 부터 6개월 이후까지 강의 리스트 찾기
     * @param dateTime 검색 시점일(현재로 부터 전후 7일까지)
     * @return
     */
    List<Lecture> findByDateTime(LocalDateTime dateTime);

    /**
     * 강의 가격을 특정 가격 이하의 강의 리스트 찾기
     * @param price 최대 가격
     * @return
     */
    List<Lecture> findByPrice(int price);

    /**
     * 강의를 수강 신청한 학생의 수가 특정 숫자 이하인 강의 리스트 찾기
     * @param studentCount 현재 수강신청한 최대 학생수
     * @return
     */
    List<Lecture> findByStudentCount(int studentCount);

    /**
     * 강의의 상태로 강의 리스트 찾기
     * @param lectureStatus 강의 상태
     * @return
     */
    List<Lecture> findByStatus(LectureStatus lectureStatus);
}
