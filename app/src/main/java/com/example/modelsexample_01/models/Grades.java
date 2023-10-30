package com.example.modelsexample_01.models;

public class Grades {

    String cod;
    int student_cod;
    String course;
    String teacher;
    String date;
    int grade;

    public Grades(String cod, int student_cod, String course, String teacher, String date, int grade) {
        this.cod = cod;
        this.student_cod = student_cod;
        this.course = course;
        this.teacher = teacher;
        this.date = date;
        this.grade = grade;
    }

    public String getCod() {
        return cod;
    }

    public int getStudent_cod() {
        return student_cod;
    }

    public void setStudent_cod(int student_cod) {
        this.student_cod = student_cod;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
