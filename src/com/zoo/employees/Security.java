package com.zoo.employees;

import com.zoo.animals.Animal;

public class Security extends Employee {
    public Security (String name) {
        super(name, "Охранник");
    }
    
    @Override
    public void performDuty() {
        System.out.println(getName() + " охраняет");
    }
    

}