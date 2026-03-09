package ui;
import model.Teacher;
import service.UniversityService;
import java.util.Scanner;

public class Menu {

    private UniversityService universityService;
    private Scanner scanner;

    public Menu() {
        universityService = new UniversityService();
        scanner = new Scanner(System.in);
        universityService.initializeData();
    }

    public void start() {
        int option;
        do {
            System.out.println("\n UNIVERSITY MENU ");
            System.out.println("1. Print all teachers");
            System.out.println("2. Print all courses");
            System.out.println("3. Create new student");
            System.out.println("4. Create new course");
            System.out.println("5. List classes by student ID");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    universityService.printTeachers();
                    break;
                case 2:
                    universityService.printCourses();
                    break;
                case 3:
                    createStudentMenu();
                    break;
                case 4:
                    createCourseMenu();
                    break;
                case 5:
                    searchStudentCourses();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 6);
    }

    private void createStudentMenu() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        universityService.createStudent(name, age);
    }
    private void createCourseMenu() {
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter classroom: ");
        String classroom = scanner.nextLine();
        System.out.println("Choose teacher:");
        for (int i = 0; i < universityService.getUniversity().getTeachers().size(); i++) {
            Teacher teacher = universityService.getUniversity().getTeachers().get(i);
            System.out.println(i + ". " + teacher.getName());
        }
        int teacherOption;
        while (true) {
            System.out.print("Enter teacher option: ");
            teacherOption = scanner.nextInt();
            if (teacherOption >= 0 &&
                    teacherOption < universityService.getUniversity().getTeachers().size()) {
                break;
            }
            System.out.println("Please choose a valid option.");
        }
        Teacher teacher = universityService
                .getUniversity()
                .getTeachers()
                .get(teacherOption);
        universityService.createNewCourse(name, classroom, teacher);
    }

    private void searchStudentCourses() {
        System.out.print("Enter student Id: ");
        int id = scanner.nextInt();
        universityService.listClassesByStudentId(id);
    }
}