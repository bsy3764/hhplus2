package com.lecture.architecture.lecture.api;

import com.lecture.architecture.global.LectureReservationFacade;
import com.lecture.architecture.lecture.dto.LectureDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/lectures")
public class LectureController {

    private final LectureReservationFacade service;

    @GetMapping
    public List<LectureDto> searchLectures() {
        List<LectureDto> lectures = service.searchLectures();
        return lectures;
    }

    @GetMapping("/{id}")
    public LectureDto searchLecture(@PathVariable long id) {
        LectureDto lecture = service.searchLectureId(id);
        return lecture;
    }

    @GetMapping("/{studentCount}")
    public List<LectureDto> searchLecture(@PathVariable int studentCount) {
        List<LectureDto> lectures = service.findByStudentCount(studentCount);
        if (!lectures.isEmpty()) {
            return lectures;
        } else {
            throw new IllegalArgumentException("학생 수 이하의 강의는 찾을수 없습니다.");
        }
    }
}
