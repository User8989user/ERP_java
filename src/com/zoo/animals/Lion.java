package com.zoo.animals;

import com.zoo.interfaces.ExhibitionParticipant;

public class Lion extends Animal implements ExhibitionParticipant {
    private static final int FEEDING_TIMES = 2;
    
    public Lion(String name, int age) {
        super(name, "Лев", age);
    }
    
    @Override
    public void feed() {
        System.out.println(getName() + " (лев) получает мясо");
    }
    
    @Override
    public String getFeedingSchedule() {
        return "09:00, 18:00";
    }
    
    @Override
    public String getFoodType() {
        return "мясо";
    }
    
    @Override
    public String getHabitat() {
        return "Саванна";
    }
    
    @Override
    public String getSound() {
        return "Рык!";
    }
    
    // Реализация ExhibitionParticipant
    @Override
    public void participateInExhibition() {
        System.out.println(getName() + " участвует в выставке больших кошек");
    }
    
    @Override
    public boolean canParticipateInExhibition() {
        return isHealthy() && getAge() > 1;
    }
}