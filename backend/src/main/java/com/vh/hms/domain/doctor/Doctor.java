package com.vh.hms.domain.doctor;

import com.vh.hms.domain.appointment.Appointment;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class Doctor implements Serializable {
    @Serial
    private final static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID doctorUUID;
    @Column(name = "Doctor Name")
    private String username;
    private String password;
    private String email;
    private String specialization;
    private String CRM;
    private BigDecimal docFees;
    @OneToMany(mappedBy = "doctor")
    private final Set<Appointment> appointments = new HashSet<>();

    public Doctor() {}

    public Doctor(UUID doctorUUID, String username, String password, String email, String specialization, String CRM, BigDecimal docFees) {
        this.doctorUUID = doctorUUID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.specialization = specialization;
        this.CRM = CRM;
        this.docFees = docFees;
    }

    public UUID getDoctorUUID() {
        return doctorUUID;
    }

    public void setDoctorUUID(UUID doctorUUID) {
        this.doctorUUID = doctorUUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public BigDecimal getDocFees() {
        return docFees;
    }

    public void setDocFees(BigDecimal docFees) {
        this.docFees = docFees;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(doctorUUID, doctor.doctorUUID) && Objects.equals(email, doctor.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorUUID, email);
    }
}
