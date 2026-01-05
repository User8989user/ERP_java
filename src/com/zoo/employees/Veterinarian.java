package com.zoo.employees;

import com.zoo.animals.Animal;
import com.zoo.interfaces.MedicalCheckable;

public class Veterinarian extends Employee {
    public Veterinarian(String name) {
        super(name, "Ветеринар");
    }
    
    @Override
    public void performDuty() {
        System.out.println(getName() + " проводит медицинские осмотры животных");
    }
    
    public void checkAnimal(MedicalCheckable animal) {
        if (animal.needsMedicalCheck()) {
            animal.performMedicalCheck();
            System.out.println(getName() + " осмотрел животное");
        } else {
            System.out.println("Животное не требует осмотра");
        }
    }
}