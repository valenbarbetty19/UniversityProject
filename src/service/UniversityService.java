package service;

import model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversityService {
    private University university;
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

        university = new University();
        university.addStudent(student1);
        university.addStudent(student2);
        university.addStudent(student3);
        university.addStudent(student4);
        university.addStudent(student5);
        university.addStudent(student6);

        university.addTeacher(fullTime1);
        university.addTeacher(fullTime2);
        university.addTeacher(partTime1);
        university.addTeacher(partTime2);

        university.addCourse(course1);
        university.addCourse(course2);
        university.addCourse(course3);
        university.addCourse(course4);

    }

    public void printTeachers(){
        for(Teacher teacher: university.getTeachers()){
            System.out.println("TEACHERS DATA FROM THE UNIVERSITY: \n");
            if(teacher instanceof FullTimeTeacher){
                System.out.println("Name: " + teacher.getName() + " Base Salary: " + teacher.getBaseSalary() + " Total salary: " + teacher.calculateSalary() + " Type of contract: Full Time");
            } else {
                System.out.println("Name: " + teacher.getName() + " Base Salary: " + teacher.getBaseSalary() + " Total salary: " + teacher.calculateSalary() + " Type of contract: Part Time");
            }
        }
    }

    public void printCourses(int option){
        int i = 0;
        //Imprimo los cursos
        for(i = 0; i <= university.getCourses().size() - 1; i++){
            System.out.println("UNIVERSITY COURSES, PLEASE SELECT AN OPTION TO SEE A COURSE IN DETAIL\n");
            System.out.println(i + ". " + university.getCourses().get(i).getName());
        }

        if(option <= university.getCourses().size()){
            List<Student> studentsCourse = university.getCourses().get(option).getStudents();
            List<String> studentsNames = new ArrayList<>();

            System.out.println("Name: " + university.getCourses().get(option).getName() +
                    "\n Classroom: " + university.getCourses().get(option).getName() +
                    "\n Students: ");
            for (Student s: studentsCourse){
                System.out.println(studentsNames.add(s.getName()));
            }
            System.out.println(university.getCourses().get(option).getTeacher().getName());
        } else {
            System.out.println("Please choose a valid option");
        }

    }

    public void createStudent(int id, String name, int age, int courseOption){
        Student student = new Student(id, name, age);
        for(int i = 0; i <= university.getCourses().size() - 1; i++){
            System.out.println("UNIVERSITY COURSES, PLEASE SELECT A COURSE TO ADD THE STUDENT \n");
            System.out.println(i + ". " + university.getCourses().get(i).getName());
        }
        if(university.getCourses().size() <= courseOption){
            university.getCourses().get(courseOption).addStudent(student);
        } else {
            System.out.println("Please choose a valid option");
        }
    }

    public void createNewCourse(String name, String classroom, Teacher teacher) {

        Scanner scanner = new Scanner(System.in);
        Course course = new Course(name, classroom, teacher);
        System.out.println("Choose the students you want to add to the new course: ");
        for (int i = 0; i < university.getStudents().size(); i++) {
            System.out.println(i + ". " + university.getStudents().get(i).getName());
        }

        System.out.println("Enter the number of students to add (type -1 to finish):");

        int option;
        while (true) {

            option = scanner.nextInt();

            if (option == -1) {
                break;
            }

            if (option >= 0 && option < university.getStudents().size()) {

                Student student = university.getStudents().get(option);
                course.addStudent(student);

                System.out.println(student.getName() + " added to the course.");

            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        university.addCourse(course);
        System.out.println("Course created successfully!");
    }
    public void listClassesByStudentId(int studentId) {
        boolean found = false;
        for (Course course : university.getCourses()) {
            for (Student student : course.getStudents()) {
                if (student.getId() == studentId) {
                    System.out.println("Student is in: " + course.getName() + " course");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("The student is not in any course.");
        }
    }
}
