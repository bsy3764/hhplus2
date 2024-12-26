package com.lecture.architecture.reservation.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 데이터베이스에 위임하는 전략
    private Long id;

    @Column(length = 50, nullable = false)
    @NotNull
    private String studentId;

    @Column(nullable = false)
    private long lectureId;

    @Column(nullable = false)
    @CreatedDate    // 생성일 자동 저장
    private LocalDateTime dateTime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    public Reservation() {
    }

    @Builder
    public Reservation(Long id, String studentId, long lectureId, LocalDateTime dateTime, ReservationStatus status) {
        this.id = id;
        this.studentId = studentId;
        this.lectureId = lectureId;
        this.dateTime = dateTime;
        this.status = status;
    }
}
