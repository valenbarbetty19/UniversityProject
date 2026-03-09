package model;

public class PartTimeTeacher extends Teacher{
    private double hoursPerWeek;
    public PartTimeTeacher(String name, double baseSalary, double hoursPerWeek) {
        super(name, baseSalary);
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public double calculateSalary() {
        return Math.round(getBaseSalary() * hoursPerWeek);
    }

}
