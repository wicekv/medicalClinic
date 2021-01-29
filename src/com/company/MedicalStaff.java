package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicalStaff extends Employee
{
    String numberCodeMedic;
    List<Patient> assignedPatients = new ArrayList<>();

    public MedicalStaff(String code_employe, String name, String surname, LocalDate dayOfBirth, LocalDate dateOfEmployment, float salary, String numberCodeMedic)
    {
        super(code_employe, name, surname, dayOfBirth, dateOfEmployment, salary);
        this.numberCodeMedic=numberCodeMedic;
    }

    public void assignPatient(Patient patient){
        assignedPatients.add(patient);
    }

    public String assignToString(Patient patient) {
        return patient.toString() + "\nnastępujące procedury: " + patient.howProcedure;
    }
}
