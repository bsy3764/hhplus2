package com.lecture.architecture.domain.lecture;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 데이터베이스에 위임하는 전략
    private long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 50)
    private String instructor;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    @Range(min = 5000, max = 1000000)
    private int price;

    @Column(nullable = false)
    @Max(30)
    private int studentCount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)    // 열거타입 이름을 값으로 저장
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
