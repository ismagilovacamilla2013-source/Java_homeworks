package com.example.lesson_6;

import java.util.*;
public class StudentManager {
    public static void removeStudents(Set<Student> students) {
        List<Student> toRemove = new ArrayList<>();
        for (Student student : students) {
            if(student.getAverageGrade() < 3){
                toRemove.add(student);
                System.out.println("Низкий проходной балл: " + student.getName() + " (средний балл: " + student.getAverageGrade() + ")");
            }

        }
        students.removeAll(toRemove);
        System.out.println("Удалено студентов:" + toRemove.size());
    }
    public static void transferStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.canMoveToNextCourse()) {
                int oldCourse = student.getCourse();
                student.setCourse(oldCourse + 1);
                System.out.println("Переведен: " + student.getName() + " с " + oldCourse +
                        " на " + (oldCourse + 1) + " курс");
            }
            else {
                System.out.println("Оставлен: " + student.getName() + " на " + student.getCourse() +
                        " курсе (средний балл: " + student.getAverageGrade() + " < 3)");
            }
        }
    }

    public static void printStudents (Set<Student> students, int course) {
        System.out.println("Студенты на " + course + " курсе:");
        int count = 0;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
                count = count + 1;
            }
        }
        if (count == 0) {
            System.out.println("Нет студентов");
        }
    }

    public static void printAll(Set<Student> students) {
        System.out.println("ВСЕ СТУДЕНТЫ:");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("Всего: " + students.size());
    }
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Анна Петрова", "ИТ-101", 2, Arrays.asList(4, 5, 4, 5, 4)));
        students.add(new Student("Иван Сидоров", "ИТ-101", 2, Arrays.asList(3, 3, 4, 3, 3)));
        students.add(new Student("Петр Иванов", "ИТ-102", 2, Arrays.asList(2, 3, 2, 2, 3)));
        students.add(new Student("Мария Смирнова", "ИТ-102", 3, Arrays.asList(5, 5, 5, 5, 5)));
        students.add(new Student("Алексей Козлов", "ИТ-103", 1, Arrays.asList(4, 4, 3, 4, 3)));
        printAll(students);
        removeStudents(students);
        printAll(students);
        transferStudents(students);
        printAll(students);

        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);
        printStudents(students, 4);

    }
}
