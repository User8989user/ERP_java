package com.zoo.employees;

import com.zoo.animals.Animal;

public class Cleaner extends Employee {
    public Cleaner (String name) {
        super(name, "Сотрудник клининга");
    }
    
    @Override
    public void performDuty() {
        System.out.println(getName() + " наводит чистоту и порядок");
    }
    

}