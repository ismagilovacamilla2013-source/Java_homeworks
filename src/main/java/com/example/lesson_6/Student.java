package com.example.lesson_6;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student (String name, String group,int course, List<Integer> grades){
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>(grades);
    }

    public String getName (){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup(){
        return group;
    }

    public void setGroup (String group) {
        this.group = group;
    }

    public int getCourse(){
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public List<Integer> getGrades(){
        return new ArrayList<>(grades);
    }

    public void setGrades(List<Integer>grades){
        this.grades = new ArrayList<>(grades);
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverageGrade () {
        if (grades.isEmpty()) {
            return 0;
        }


        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.size();
    }
     public boolean canMoveToNextCourse () {
        return getAverageGrade() >= 3;
     }

     @Override
    public String toString(){
        return name + " (группа: " + group + ", курс:" + course + ", средний балл: " + getAverageGrade() + ")";
     }
}
