package com.lecture.architecture.lecture.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LectureDto {
    private Long id;
    private String title;
    private int price;
    private LocalDateTime dateTime;
    private String status;
}
