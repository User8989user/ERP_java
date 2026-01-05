package com.zoo.interfaces;

import java.time.LocalDate;

public interface MedicalCheckable {
    void performMedicalCheck();
    LocalDate getLastCheckDate();
    boolean needsMedicalCheck();
}