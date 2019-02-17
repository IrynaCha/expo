package com.iru.domain;

import java.time.LocalDate;
import java.util.Objects;

public class StudDomain extends PersonaDomain {
    private Long id;
    private LocalDate enrolmentDate;

    public StudDomain() {
    }

    public StudDomain(String firstName, String lastName){
        super(firstName, lastName);
    }

    public StudDomain(Long id, LocalDate enrolmentDate) {
        this.id = id;
        this.enrolmentDate = enrolmentDate;
    }

    public StudDomain(String firstName, String lastName, String email, String phoneNumber, Long id, LocalDate enrolmentDate) {
        super(firstName, lastName, email, phoneNumber);
        this.id = id;
        this.enrolmentDate = enrolmentDate;
    }

    public StudDomain(String firstName, String lastName, String email, String phoneNumber, LocalDate enrolmentDate) {
        super(firstName, lastName, email, phoneNumber);
        this.enrolmentDate = enrolmentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEnrolmentDate() {
        return enrolmentDate;
    }

    public void setEnrolmentDate(LocalDate enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudDomain student = (StudDomain) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "StudDomain{" +
                "id=" + id +
                '}';
    }
}
