package model;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Course> courses;

    public University() {
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addTeacher(Teacher teacher){
        this.teachers.add(teacher);
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }
}
