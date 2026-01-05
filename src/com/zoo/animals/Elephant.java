package com.zoo.animals;

import com.zoo.interfaces.ExhibitionParticipant;

public class Elephant extends Animal implements ExhibitionParticipant {
    private static final int FEEDING_TIMES = 2;
    private static int numOfCrocGena = 0;
    
    public Elephant( String name, int age) {
        super(name, "Слон", age);
    }
    

    @Override
    public void feed() {
        System.out.println(getName() + " (Слон) получает сено и минеральные добавки");
    }
    
    @Override
    public String getFeedingSchedule() {
        return "09:00, 18:00";
    }
    
    @Override
    public String getFoodType() {
        return "сено  и минеральные добавки";
    }
    
    @Override
    public String getHabitat() {
        return "Саванна";
    }
    
    @Override
    public String getSound() {
        return "Трубит уууууууууууу!";
    }
    
    // Реализация ExhibitionParticipant
    @Override
    public void participateInExhibition() {
        System.out.println(getName() + " участвует в сборе яблок в саду ");
    }
    
    @Override
    public boolean canParticipateInExhibition() {
        return isHealthy() && getAge() > 1;
    }
}