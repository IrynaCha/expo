package com.iru.domain;

import java.util.Objects;

public class SubjDomain {
    private int id;
    private String name;

    public SubjDomain() {
    }

    public SubjDomain(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public SubjDomain(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjDomain subjDomain = (SubjDomain) o;
        return id == subjDomain.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SubjDomain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
