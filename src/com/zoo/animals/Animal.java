package com.zoo.animals;

import com.zoo.interfaces.Feedable;
import com.zoo.interfaces.MedicalCheckable;
import java.time.LocalDate;

public abstract class Animal implements Feedable, MedicalCheckable {
    private String name;
    private String species;
    private int age;
    private LocalDate arrivalDate;
    private LocalDate lastMedicalCheck;
    private boolean isHealthy;
    
    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.arrivalDate = LocalDate.now();
        this.isHealthy = true;
    }
    
    // Геттеры и сеттеры
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }
    public LocalDate getArrivalDate() { return arrivalDate; }
    public boolean isHealthy() { return isHealthy; }
    public void setHealthy(boolean healthy) { isHealthy = healthy; }
    
    // Реализация методов из MedicalCheckable
    @Override
    public LocalDate getLastCheckDate() {
        return lastMedicalCheck;
    }
    
    @Override
    public void performMedicalCheck() {
        this.lastMedicalCheck = LocalDate.now();
        System.out.println(name + " прошел медицинский осмотр");
    }
    
    @Override
    public boolean needsMedicalCheck() {
        return lastMedicalCheck == null || 
               lastMedicalCheck.isBefore(LocalDate.now().minusMonths(6));
    }
    
    // Абстрактные методы, которые должны быть реализованы в наследниках
    public abstract String getHabitat();
    public abstract String getSound();
}
