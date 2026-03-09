package service;

import model.Course;
import model.FullTimeTeacher;
import model.PartTimeTeacher;
import model.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UniversityService {
    public void initializeData(){
        FullTimeTeacher fullTime1 = new FullTimeTeacher("Jungkook", 230);
        FullTimeTeacher fullTime2 = new FullTimeTeacher("Taehyung", 354);

        PartTimeTeacher partTime1 = new PartTimeTeacher("Jimin", 810);
        PartTimeTeacher partTime2 = new PartTimeTeacher("Jin", 965);

        Student student1 = new Student(1, "Yoongi", 31);
        Student student2 = new Student(2, "Hoseok", 29);
        Student student3 = new Student(3, "Namjoon", 29);
        Student student4 = new Student(4, "Valentina", 26);
        Student student5 = new Student(5, "Dustin", 5);
        Student student6 = new Student(6, "EunWoo", 23);



        Course course1 = new Course("Art", "A101", fullTime1);
        Course course2 = new Course("Music", "B102", fullTime2);
        Course course3 = new Course("Math", "C103", partTime1);
        Course course4 = new Course("French", "D104", partTime2);

        course1.addStudent(student1);
        course1.addStudent(student2);
        course1.addStudent(student3);

        course2.addStudent(student4);
        course2.addStudent(student5);
        course2.addStudent(student6);

        course3.addStudent(student2);
        course3.addStudent(student4);
        course3.addStudent(student6);

        course4.addStudent(student1);
        course4.addStudent(student3);
        course4.addStudent(student5);



    }

    public void printTeachers(){

    }
}
