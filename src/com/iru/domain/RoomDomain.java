package com.iru.domain;

import java.util.Objects;

public class RoomDomain {
    private int id;
    private String number;

    public RoomDomain() {
    }

    public RoomDomain(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public RoomDomain(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDomain room = (RoomDomain) o;
        return id == room.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RoomDomain [id=" + id + ", number=" + number + "]";
    }
}
