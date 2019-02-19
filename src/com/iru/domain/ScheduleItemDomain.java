package com.iru.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class ScheduleItemDomain {
    private int id;
    private SubjDomain subjDomain;
    private SubjectType subjectType = SubjectType.PRACTICE;
    private RoomDomain room;
    private TeachDomain teachDomain;
    private GrouDomain group;
    private LocalDateTime date;

    public ScheduleItemDomain() {
    }

    public ScheduleItemDomain(int id, SubjDomain subjDomain, SubjectType subjectType, RoomDomain room, TeachDomain teachDomain, GrouDomain group, LocalDateTime date) {
        this.id = id;
        this.subjDomain = subjDomain;
        this.subjectType = subjectType;
        this.room = room;
        this.teachDomain = teachDomain;
        this.group = group;
        this.date = date;
    }

    public ScheduleItemDomain(SubjDomain subjDomain, SubjectType subjectType, RoomDomain room, TeachDomain teachDomain, GrouDomain group, LocalDateTime date) {
        this.subjDomain = subjDomain;
        this.subjectType = subjectType;
        this.room = room;
        this.teachDomain = teachDomain;
        this.group = group;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SubjDomain getSubjDomain() {
        return subjDomain;
    }

    public void setSubjDomain(SubjDomain subjDomain) {
        this.subjDomain = subjDomain;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public RoomDomain getRoom() {
        return room;
    }

    public void setRoom(RoomDomain room) {
        this.room = room;
    }

    public TeachDomain getTeachDomain() {
        return teachDomain;
    }

    public void setTeachDomain(TeachDomain teachDomain) {
        this.teachDomain = teachDomain;
    }

    public GrouDomain getGroup() {
        return group;
    }

    public void setGroup(GrouDomain group) {
        this.group = group;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleItemDomain scheduleItem = (ScheduleItemDomain) o;
        return Objects.equals(subjDomain, scheduleItem.subjDomain) &&
                Objects.equals(room, scheduleItem.room) &&
                Objects.equals(group, scheduleItem.group) &&
                Objects.equals(date, scheduleItem.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjDomain, room, group, date);
    }

    @Override
    public String toString() {
        return "ScheduleItemDomain{" +
                "subjDomain=" + subjDomain +
                ", room=" + room +
                ", date=" + date +
                '}';
    }
}
