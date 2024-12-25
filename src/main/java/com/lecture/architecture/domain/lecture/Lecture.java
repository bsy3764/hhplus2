package com.lecture.architecture.domain.lecture;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

@Entity
//@RequiredArgsConstructor
public class Lecture {

    @Id @GeneratedValue()
    private long id;

    @NotNull
    private String title;
    
    private String instructor;
    private LocalDateTime dateTime;

    @Range(min = 5000, max = 1000000)
    private int price;

    @Max(30)
    private int studentCount;
    private LectureStatus status;

    @Builder
    public Lecture(long id, String title, String instructor, LocalDateTime dateTime, int price, int studentCount, LectureStatus status) {
        this.id = id;
        this.title = title;
        this.instructor = instructor;
        this.dateTime = dateTime;
        this.price = price;
        this.studentCount = studentCount;
        this.status = status;
    }
}
