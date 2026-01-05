package com.zoo.reports;

import com.zoo.animals.Animal;
import com.zoo.interfaces.ExhibitionParticipant;
import com.zoo.interfaces.Feedable;
import com.zoo.interfaces.MedicalCheckable;
import java.util.List;

public class ReportGenerator {
    private List<Animal> animals;
    
    public ReportGenerator(List<Animal> animals) {
        this.animals = animals;
    }
    
    public void generateDailyReport() {
        System.out.println("\n=== Московский зоопарк - Ежедневный отчет ===");
        System.out.println("Всего животных: " + animals.size());
        
        System.out.println("\nРасписание кормления:");
        for (Animal animal : animals) {
            if (animal instanceof Feedable) {
                System.out.println("- " + animal.getName() + " (" + animal.getSpecies() + 
                                 "): " + ((Feedable) animal).getFoodType() + 
                                 " (" + ((Feedable) animal).getFeedingSchedule() + ")");
            }
        }
        
        System.out.println("\nМедицинские осмотры:");
        int needCheck = 0;
        for (Animal animal : animals) {
            if (animal instanceof MedicalCheckable) {
                MedicalCheckable medAnimal = (MedicalCheckable) animal;
                if (medAnimal.needsMedicalCheck()) {
                    System.out.println("- " + animal.getName() + ": требует осмотра");
                    needCheck++;
                } else {
                    System.out.println("- " + animal.getName() + ": осмотрен " + 
                                     medAnimal.getLastCheckDate());
                }
            }
        }
        
        System.out.println("\nВыставки:");
        int canExhibit = 0;
        for (Animal animal : animals) {
            if (animal instanceof ExhibitionParticipant) {
                ExhibitionParticipant exAnimal = (ExhibitionParticipant) animal;
                if (exAnimal.canParticipateInExhibition()) {
                    canExhibit++;
                }
            }
        }
        System.out.println(canExhibit + " животных могут участвовать в выставках");
        
        System.out.println("\nСтатистика по видам:");
        animals.stream()
               .collect(java.util.stream.Collectors.groupingBy(Animal::getSpecies, 
                       java.util.stream.Collectors.counting()))
               .forEach((species, count) -> 
                       System.out.println("- " + species + ": " + count));
    }
}