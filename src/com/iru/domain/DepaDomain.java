package com.iru.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepaDomain {
    private int id;
    private String name;
    private String abbreviation;
    private List<GrouDomain> grouDomains = new ArrayList<>();
    private List<TeachDomain> teachDomains = new ArrayList<>();
    private List<SubjDomain> subjDomains = new ArrayList<>();

    public DepaDomain() {
    }

    public DepaDomain(int id, String name, String abbreviation, List<GrouDomain> grouDomains, List<TeachDomain> teachDomains,
                      List<SubjDomain> subjDomains) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.grouDomains = grouDomains;
        this.teachDomains = teachDomains;
        this.subjDomains = subjDomains;
    }

    public DepaDomain(String name) {
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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public List<GrouDomain> getGrouDomains() {
        return grouDomains;
    }

    public void setGrouDomains(List<GrouDomain> grouDomains) {
        this.grouDomains = grouDomains;
    }

    public List<TeachDomain> getTeachDomains() {
        return teachDomains;
    }

    public void setTeachDomains(List<TeachDomain> teachDomains) {
        this.teachDomains = teachDomains;
    }

    public List<SubjDomain> getSubjDomains() {
        return subjDomains;
    }

    public void setSubjDomains(List<SubjDomain> subjDomains) {
        this.subjDomains = subjDomains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DepaDomain that = (DepaDomain) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DepaDomain [id=" + id + ", name=" + name + ", abbreviation=" + abbreviation + "]";
    }
}
