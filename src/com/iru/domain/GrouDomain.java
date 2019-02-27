package com.iru.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GrouDomain {
    private Long id;
    private Long department_id;
    private String name;
    private List<StudDomain> students = new ArrayList<>();

    public GrouDomain() {
    }

    public GrouDomain(String name) {
        this.name = name;
    }

    public GrouDomain(String name, List<StudDomain> students) {
        this.name = name;
        this.students = students;
    }

    public GrouDomain(Long id, String name, List<StudDomain> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public GrouDomain(Long id, Long department_id, String name, List<StudDomain> students) {
        this.id = id;
        this.department_id = department_id;
        this.name = name;
        this.students = students;
    }

    public GrouDomain(Long department_id, String name) {
        this.department_id = department_id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public List<StudDomain> getStudents() {
        return students;
    }

    public void setStudDomains(List<StudDomain> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GrouDomain group = (GrouDomain) o;
        return id == group.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Group [id=" + id + ", name=" + name + "]";
    }
}
