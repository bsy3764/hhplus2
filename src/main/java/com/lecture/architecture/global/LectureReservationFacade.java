package com.lecture.architecture.global;

import com.lecture.architecture.lecture.domain.Lecture;
import com.lecture.architecture.lecture.domain.LectureService;
import com.lecture.architecture.lecture.dto.LectureDto;
import com.lecture.architecture.reservation.domain.Reservation;
import com.lecture.architecture.reservation.domain.ReservationService;
import com.lecture.architecture.reservation.dto.ReservationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LectureReservationFacade {

    private final LectureService lectureService;
    private final ReservationService reservationService;

    // 신청할 수 있는 강의 목록 출력
    public List<LectureDto> searchLectures() {
        List<Lecture> lectureServiceByDateTime = lectureService.findByDateTime(LocalDateTime.now());

        List<LectureDto> dtoList = new ArrayList<>();
        for (Lecture lecture : lectureServiceByDateTime) {
            LectureDto lectureDto = lectureEntityToDto(lecture);

            dtoList.add(lectureDto);
        }
        return dtoList;
    }

    public LectureDto searchLectureId(long id) {
        Optional<Lecture> optionalLecture = lectureService.findById(id);
        if (optionalLecture.isPresent()) {
            Lecture lecture = optionalLecture.get();

            return lectureEntityToDto(lecture);
        } else {
            throw new IllegalArgumentException("해당 강의ID의 강의는 찾을수 없습니다.");
        }
    }

    public List<LectureDto> findByStudentCount(int studentCount) {
        List<Lecture> lectureServiceByDateTime = lectureService.findByDateTime(LocalDateTime.now());

        List<LectureDto> dtoList = new ArrayList<>();
        if (!lectureServiceByDateTime.isEmpty()) {
            for (Lecture lecture : lectureServiceByDateTime) {
                LectureDto lectureDto = lectureEntityToDto(lecture);

                dtoList.add(lectureDto);
            }
        } else {
            throw new IllegalArgumentException("학생 수 이하의 강의는 찾을수 없습니다.");
        }
        return dtoList;
    }

    // 강의 신청
    public ReservationDto requestReservation(long lectureId, String studentId) {
        Optional<Reservation> reservationCheck = reservationService.findByLectureId(lectureId);
        if (reservationCheck.isPresent()) {
            throw new RuntimeException("이미 신청한 강의 입니다.");
        }

        boolean addedStudentCount = lectureService.addStudentCount(lectureId);

        if (addedStudentCount) {
            reservationService.registReservation(lectureId, studentId);

            Optional<Reservation> reservationOptional = reservationService.findByLectureId(lectureId);
            if (reservationOptional.isPresent()) {
                Reservation reservation = reservationOptional.get();
                return reservationEntityToDto(reservation);
            } else {
                throw new RuntimeException("신청에 에러가 발생했습니다");
            }
        } else {
            throw new RuntimeException("이미 정원이 가득차 신청이 불가능합니다.");
        }
    }

    // 학생 ID로 예약한 내역 확인
    public List<ReservationDto> getReservationByStudentId(String studentId) {
        List<Reservation> reservationList = reservationService.findByStudentId(studentId);
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            ReservationDto reservationDto = reservationEntityToDto(reservation);
        }
        return reservationDtoList;
    }

    private LectureDto lectureEntityToDto(Lecture lecture){
        LectureDto lectureDto = new LectureDto();
        lectureDto.setId(lecture.getId());
        lectureDto.setTitle(lecture.getTitle());
        lectureDto.setPrice(lecture.getPrice());
        lectureDto.setDateTime(lecture.getDateTime());
        lectureDto.setStatus(lecture.getStatus().toString());

        return lectureDto;
    }

    private ReservationDto reservationEntityToDto(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservation.getId());
        reservationDto.setStudentId(reservation.getStudentId());
        reservationDto.setLectureId(reservation.getLectureId());

        Optional<Lecture> optionalLecture = lectureService.findById(reservation.getLectureId());
        if (optionalLecture.isPresent()) {
            Lecture lecture = optionalLecture.get();
            reservationDto.setLectureTitle(lecture.getTitle());
        }
        reservationDto.setStatus(reservation.getStatus().toString());

        return reservationDto;
    }
}
