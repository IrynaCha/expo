package com.iru.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GrouDomain {
    private int id;
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

    public GrouDomain(int id, String name, List<StudDomain> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
