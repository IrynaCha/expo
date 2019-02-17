package com.iru.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeachDomain extends PersonaDomain {
    private int id;
    private String position;
    private List<SubjDomain> subjDomains = new ArrayList<>();

    public TeachDomain() {
    }

    public TeachDomain(int id, String position, List<SubjDomain> subjDomains) {
        this.id = id;
        this.position = position;
        this.subjDomains = subjDomains;
    }

    public TeachDomain(String firstName, String lastName, String email, String phoneNumber, int id, String position, List<SubjDomain> subjDomains) {
        super(firstName, lastName, email, phoneNumber);
        this.id = id;
        this.position = position;
        this.subjDomains = subjDomains;
    }

    public TeachDomain(String firstName, String lastName, String email, String phoneNumber, String position) {
        super(firstName, lastName, email, phoneNumber);
        this.position = position;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<SubjDomain> getSubjDomains() {
        return subjDomains;
    }

    public void setSubjDomains(List<SubjDomain> subjDomains) {
        this.subjDomains = subjDomains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TeachDomain teachDomain = (TeachDomain) o;
        return id == teachDomain.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "TeachDomain{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }
}
