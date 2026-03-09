package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private String classroom;
    private List<Student> students;
    private Teacher teacher;

    public Course(String name, String classroom, Teacher teacher) {
        this.name = name;
        this.classroom = classroom;
        this.students = new ArrayList<>();
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }
}
