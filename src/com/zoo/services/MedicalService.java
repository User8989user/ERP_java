package com.zoo.services;

import com.zoo.interfaces.MedicalCheckable;
import java.util.List;

public class MedicalService implements CareService {
    private List<MedicalCheckable> animals;
    
    public MedicalService(List<MedicalCheckable> animals) {
        this.animals = animals;
    }
    
    @Override
    public void provideCare() {
        System.out.println("Начинаются медицинские осмотры...");
        int checked = 0;
        for (MedicalCheckable animal : animals) {
            if (animal.needsMedicalCheck()) {
                animal.performMedicalCheck();
                checked++;
            }
        }
        System.out.println("Осмотрено животных: " + checked);
    }
}