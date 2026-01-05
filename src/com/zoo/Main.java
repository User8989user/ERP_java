package com.zoo;

import com.zoo.animals.*;
import com.zoo.employees.*;
import com.zoo.interfaces.*;
import com.zoo.reports.*;
import com.zoo.services.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ERP-система Московского зоопарка ===\n");
        
        // Создание животных
        List<Animal> animals = new ArrayList<>();
        animals.add(new Lion("Симба", 5));
        animals.add(new Crocodile(22));
        animals.add(new Crocodile(10));
        animals.add(new Crocodile(5));
        animals.add(new Elephant("Мия",11 ));

        // Добавление новых видов животных без изменения существующего кода
        animals.add(new Lion("Муфаса", 8));
        
        // Создание сотрудников
        List<Employee> employees = new ArrayList<>();
        employees.add(new Zookeeper("Иван Петров"));
        employees.add(new Veterinarian("Мария Сидорова"));
        employees.add(new Cleaner("Елена Некрасова"));
        // Демонстрация работы системы
        
        // 1. Кормление животных
        System.out.println("1. Кормление животных:");
        List<Feedable> feedableAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Feedable) {
                feedableAnimals.add((Feedable) animal);
            }
        }
        
        FeedingService feedingService = new FeedingService(feedableAnimals);
        feedingService.feedAll();
        
        // 2. Медицинские осмотры
        System.out.println("\n2. Медицинские осмотры:");
        List<MedicalCheckable> medicalAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof MedicalCheckable) {
                medicalAnimals.add((MedicalCheckable) animal);
            }
        }
        
        MedicalService medicalService = new MedicalService(medicalAnimals);
        medicalService.provideCare();
        
        // 3. Работа сотрудников
        System.out.println("\n3. Работа сотрудников:");
        for (Employee employee : employees) {
            employee.performDuty();
            if (employee instanceof Zookeeper) {
                ((Zookeeper) employee).feedAnimal(feedableAnimals.get(0));
            } else if (employee instanceof Veterinarian) {
                ((Veterinarian) employee).checkAnimal(medicalAnimals.get(0));
            }
        }
        
        // 4. Выставки
        System.out.println("\n4. Подготовка к выставкам, соревнованиям и мероприятиям:");
        for (Animal animal : animals) {
            if (animal instanceof ExhibitionParticipant) {
                ExhibitionParticipant exAnimal = (ExhibitionParticipant) animal;
                if (exAnimal.canParticipateInExhibition()) {
                    exAnimal.participateInExhibition();
                }
            }
        }
        
        // 5. Генерация отчета
        System.out.println("\n5. Отчетность:");
        ReportGenerator reportGenerator = new ReportGenerator(animals);
        reportGenerator.generateDailyReport();
        
        // Демонстрация легкости добавления новых животных
        System.out.println("\n6. Добавление нового животного:");
        Animal newAnimal = new Lion("Лео", 3);
        animals.add(newAnimal);
        System.out.println("Добавлен новый лев: " + newAnimal.getName());
        
        // Обновленный отчет
        reportGenerator = new ReportGenerator(animals);
        reportGenerator.generateDailyReport();
    }
}