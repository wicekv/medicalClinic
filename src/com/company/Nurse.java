package com.company;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Nurse extends MedicalStaff{

    public Nurse(String code_employe, String name, String surname, LocalDate dayOfBirth, LocalDate dateOfEmployment, float salary, String numberCodeMedic)
    {
        super(code_employe, name, surname, dayOfBirth, dateOfEmployment, salary, numberCodeMedic);
        procedureN();
    }
    private static final Logger LOGGER = Logger.getLogger(Nurse.class.getName());
    List<String> procedureNurse = new ArrayList<>();

    public void procedureN()
    {
        procedureNurse.add("Zastrzyk");
        procedureNurse.add("Pomiar wagi");
        procedureNurse.add("Pomiar ciśnienia");
        procedureNurse.add("Pobieranie Krwi");
    }

    @Override
    public void assignPatient(Patient patient)
    {
        super.assignPatient(patient);
        try {
            FileHandler handler = new FileHandler("logs.txt");
            LOGGER.addHandler(handler);
            LOGGER.info("\nPielęgniarka o imieniu: " + name + ", nazwisku: " + surname + " i numerze uprawnień: " +
                    numberCodeMedic + " wykonała na pacjencie o danych: " + super.assignToString(patient));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nPielęgniarka o imieniu: " + name + ", nazwisku: " + surname + " i numerze uprawnień: " +
                numberCodeMedic + " wykonała na pacjencie o danych: " + super.assignToString(patient));
    }
}
