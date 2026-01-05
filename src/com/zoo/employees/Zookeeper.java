package com.zoo.employees;

import com.zoo.animals.Animal;
import com.zoo.interfaces.Feedable;

public class Zookeeper extends Employee {
    public Zookeeper(String name) {
        super(name, "Смотритель");
    }
    
    @Override
    public void performDuty() {
        System.out.println(getName() + " кормит животных и убирает в вольерах");
    }
    
    public void feedAnimal(Feedable animal) {
        animal.feed();
        System.out.println(getName() + " покормил животное");
    }
}
