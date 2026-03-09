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

        ArrayList<Student> course1Students = new ArrayList<>();
        ArrayList<Student> course2Students = new ArrayList<>();
        ArrayList<Student> course3Students = new ArrayList<>();
        ArrayList<Student> course4Students = new ArrayList<>();

        course1Students.add(student1);
        course1Students.add(student2);
        course1Students.add(student3);

        course2Students.add(student4);
        course2Students.add(student5);
        course2Students.add(student6);

        course3Students.add(student2);
        course3Students.add(student4);
        course3Students.add(student6);

        course4Students.add(student1);
        course4Students.add(student3);
        course4Students.add(student5);


        Course course1 = new Course("Art", "A101", course1Students, fullTime1);
        Course course2 = new Course("Music", "B102", course2Students, fullTime2);
        Course course3 = new Course("Math", "C103", course3Students, partTime1);
        Course course4 = new Course("French", "D104", course4Students, partTime2);



    }
}
