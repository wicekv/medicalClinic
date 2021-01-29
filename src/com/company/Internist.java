package com.company;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Internist extends Doctor{
    public Internist(String code_employe, String name, String surname, LocalDate dayOfBirth, LocalDate dateOfEmployment, float salary, String numberCodeMedic)
    {
        super(code_employe, name, surname, dayOfBirth, dateOfEmployment, salary, numberCodeMedic);
    }
    private static final Logger LOGGER = Logger.getLogger(Nurse.class.getName());

    @Override
    public void assignPatient(Patient patient)
    {
        super.assignPatient(patient);
        try {
            FileHandler handler = new FileHandler("logs.txt");
            LOGGER.addHandler(handler);
            LOGGER.info("\nInternista o imieniu: " + name + ", nazwisku: " + surname + " i numerze uprawnień: " +
                    numberCodeMedic + ", wykonał na pacjencie o danych: " + super.assignToString(patient));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nInternista o imieniu: " + name + ", nazwisku: " + surname + " i numerze uprawnień: " +
                numberCodeMedic + ", wykonał na pacjencie o danych: " + super.assignToString(patient));
    }
}
