package com.vh.hms.repositories;

import com.vh.hms.domain.doctor.Doctor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    <S extends Doctor> Page<S> findAllBySpecialization(String specialization, Pageable pageable);
    Optional<Doctor> findByEmailEquals(String email);
    boolean existsByUsernameEquals(String username);
    void deleteByEmail(String email);
}
