package service;

import model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversityService {
    private University university;
    Scanner scanner = new Scanner(System.in);
    public void initializeData(){
        FullTimeTeacher fullTime1 = new FullTimeTeacher("Jungkook", 230, 5);
        FullTimeTeacher fullTime2 = new FullTimeTeacher("Taehyung", 354, 3);

        PartTimeTeacher partTime1 = new PartTimeTeacher("Jimin", 810, 20);
        PartTimeTeacher partTime2 = new PartTimeTeacher("Jin", 965, 23);

        Student student1 = new Student("Yoongi", 31);
        Student student2 = new Student("Hoseok", 29);
        Student student3 = new Student("Namjoon", 29);
        Student student4 = new Student("Valentina", 26);
        Student student5 = new Student("Dustin", 5);
        Student student6 = new Student("EunWoo", 23);



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
        System.out.println("TEACHERS DATA FROM THE UNIVERSITY: \n");
        int i = 0;
        for(Teacher teacher: university.getTeachers()){

            if(teacher instanceof FullTimeTeacher){
                System.out.println(i + ". Name: " + teacher.getName() + "\n  Base Salary: " + teacher.getBaseSalary() + "\n  Total salary:" + teacher.calculateSalary() + "\n  Type of contract: Full Time");
                i++;
            } else {
                System.out.println(i + ". Name: " + teacher.getName() + "\n  Base Salary: " + teacher.getBaseSalary() + "\n  Total salary:" + teacher.calculateSalary() + "\n  Type of contract: Part Time");
                i++;
            }
        }
    }

    public void printCourses(){
        System.out.println("UNIVERSITY COURSES: \n");
        //Imprimo los cursos
        for(int i = 0; i <= university.getCourses().size() - 1; i++){
            System.out.println(i + ". " + university.getCourses().get(i).getName());
        }
        System.out.println("Please choose an option to see a course in detail: ");
        int option = scanner.nextInt();
        if(option >= 0 && option < university.getCourses().size()){
            List<Student> studentsCourse = university.getCourses().get(option).getStudents();

            System.out.println("Name: " + university.getCourses().get(option).getName() +
                    "\nClassroom: " + university.getCourses().get(option).getClassroom() +
                    "\nStudents: ");
            for(int i = 0; i <= studentsCourse.size() - 1; i++){
                System.out.println("  - " + studentsCourse.get(i).getName());
            }

            System.out.println("Teacher: " + university.getCourses().get(option).getTeacher().getName());
        } else {
            System.out.println("Please choose a valid option");
        }

    }

    public void createStudent(String name, int age) {
        Student student = new Student(name, age);
        int courseOption = -1;
        while (true) {
            System.out.println("Choose course option:");
            for (int i = 0; i < university.getCourses().size(); i++) {
                System.out.println(i + ". " + university.getCourses().get(i).getName());
            }
            courseOption = scanner.nextInt();
            if (courseOption >= 0 && courseOption < university.getCourses().size()) {
                Course course = university.getCourses().get(courseOption);
                course.addStudent(student);
                university.addStudent(student);
                System.out.println("Student added successfully to the course: " + course.getName());
                break;
            } else {
                System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public void createNewCourse(String name, String classroom, Teacher teacher) {
        Course course = new Course(name, classroom, teacher);
        System.out.println("Choose the students you want to add to the new course: ");
        for (int i = 0; i < university.getStudents().size(); i++) {
            System.out.println(i + ". " + university.getStudents().get(i).getName());
        }

        System.out.println("Enter the number of students to add, type -1 to finish:");

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

    public University getUniversity() {
        return university;
    }
}
