package com.lecture.architecture.domain.lecture;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/lectures")
public class LectureController {

    private final LectureService service;

    @GetMapping
    public List<Lecture> searchLectures() {
        List<Lecture> lectures = service.findByDateTime(LocalDateTime.now());
        return lectures;
    }

    @GetMapping("/{id}")
    public Lecture searchLecture(@PathVariable long id) {
        Optional<Lecture> optionalLecture = service.findById(id);
        if (optionalLecture.isPresent()) {
            return optionalLecture.get();
        } else {
            throw new IllegalArgumentException("해당 강의ID의 강의는 찾을수 없습니다.");
        }
    }
}
