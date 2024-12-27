package com.lecture.architecture.reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDto {
    private Long id;
    private String studentId;
    private Long lectureId;
    private String lectureTitle;
    private String status;
}
