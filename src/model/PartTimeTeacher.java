package model;

public class PartTimeTeacher extends Teacher{
    private double hoursPerWeek;
    public PartTimeTeacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() * hoursPerWeek;
    }
}
