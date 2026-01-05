package com.zoo.employees;

public abstract class Employee {
    private String name;
    private String position;
    private int employeeId;
    private static int nextId = 1;
    
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
        this.employeeId = nextId++;
    }
    
    public String getName() { return name; }
    public String getPosition() { return position; }
    public int getEmployeeId() { return employeeId; }
    
    public abstract void performDuty();
}