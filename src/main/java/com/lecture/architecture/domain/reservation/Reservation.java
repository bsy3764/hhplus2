package com.lecture.architecture.domain.reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Entity
//@RequiredArgsConstructor
public class Reservation {
    @Id
    private final long id;

    @NotNull
    private final String studentId;

    private final long lectureId;
    private final ReservationStatus status;

    @Builder
    public Reservation(long id, String studentId, long lectureId, ReservationStatus status) {
        this.id = id;
        this.studentId = studentId;
        this.lectureId = lectureId;
        this.status = status;
    }
}
