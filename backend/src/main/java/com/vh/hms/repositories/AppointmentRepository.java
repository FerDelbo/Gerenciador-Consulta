package com.vh.hms.repositories;

import com.vh.hms.domain.appointment.Appointment;
import com.vh.hms.domain.appointment.AppointmentStatus;
import com.vh.hms.domain.patient.Patient;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository <Appointment, UUID> {
    <S extends Appointment> Page<S> findAllByPatient_Email(String email, Pageable pageable);

    <S extends Appointment> Page<S> findAllByDoctor_Email(String email, Pageable pageable);
    boolean existsByDateAndTimeAndDoctor_Username(LocalDate date, Instant time, String username);
        List<Appointment> findAllByDateAfterAndTimeAfterAndStatusEquals(LocalDate date, Instant time, AppointmentStatus status);
}
