package com.zoo.services;

import com.zoo.interfaces.Feedable;
import java.util.List;

public class FeedingService implements CareService {
    private List<Feedable> animals;
    
    public FeedingService(List<Feedable> animals) {
        this.animals = animals;
    }
    
    @Override
    public void provideCare() {
        System.out.println("Начинается кормление животных...");
        for (Feedable animal : animals) {
            animal.feed();
        }
        System.out.println("Все животные накормлены!");
    }
    
    public void feedAll() {
        provideCare();
    }
}