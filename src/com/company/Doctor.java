package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends  MedicalStaff{

    List<String> procedureDoctor = new ArrayList<>();
    public static Doctor doctor;

    public Doctor(String code_employe, String name, String surname, LocalDate dayOfBirth, LocalDate dateOfEmployment, float salary, String numberCodeMedic)
    {
        super(code_employe, name, surname, dayOfBirth, dateOfEmployment, salary, numberCodeMedic);
        this.doctor=this;
        procedureD();
    }

    public void procedureD()
    {
        procedureDoctor.add("Zastrzyk");
        procedureDoctor.add("Pomiar wagi");
        procedureDoctor.add("Pomiar ciśnienia");
        procedureDoctor.add("Pobieranie Krwi");
        procedureDoctor.add("Badanie Ogolne"); // tylko lekarz
        procedureDoctor.add("Badanie USG"); // tylko lekarz
        procedureDoctor.add("Wypisanie Recepty"); // tylko lekarz
    }

}
