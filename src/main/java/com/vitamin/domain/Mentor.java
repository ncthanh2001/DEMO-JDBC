package com.vitamin.domain;

public class Mentor {
    private int mentorId;
    private String fullname;
    private int age;
    private boolean gender;
    public Mentor() {}

    public Mentor(int mentorId, String fullname, int age, boolean gender) {
        this.mentorId = mentorId;
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Mentor: " + this.fullname + " - " + this.getAge() + " - "+ ( isGender() ? "Nữ ": "Nam");
    }
}
