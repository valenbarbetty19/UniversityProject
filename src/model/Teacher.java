package model;

public abstract class Teacher {
    private String name;
    private double BaseSalary;

    public Teacher(String name, double baseSalary) {
        this.name = name;
        BaseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return BaseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        BaseSalary = baseSalary;
    }

    public abstract double calculateSalary();
}
