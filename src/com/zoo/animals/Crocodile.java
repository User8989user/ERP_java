package com.zoo.animals;

import com.zoo.interfaces.ExhibitionParticipant;

public class Crocodile extends Animal implements ExhibitionParticipant {
    private static final int FEEDING_TIMES = 2;
    private static int numOfCrocGena = 0;
    
    public Crocodile( String name, int age) {
        super(name, "Крокодил", age);
    }
    
     public Crocodile(int age) {
        this("Гена " + (++numOfCrocGena), age);
    }


    @Override
    public void feed() {
        System.out.println(getName() + " (крокодил) получает корм для крокодила");
    }
    
    @Override
    public String getFeedingSchedule() {
        return "09:00, 18:00";
    }
    
    @Override
    public String getFoodType() {
        return "корм для крокодила";
    }
    
    @Override
    public String getHabitat() {
        return "Водоем";
    }
    
    @Override
    public String getSound() {
        return "Скрежет зубов!";
    }
    
    // Реализация ExhibitionParticipant
    @Override
    public void participateInExhibition() {
        System.out.println(getName() + " участвует в соревновании по нырянию ");
    }
    
    @Override
    public boolean canParticipateInExhibition() {
        return isHealthy() && getAge() > 1;
    }
}