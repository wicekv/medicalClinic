package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class OfficeStaffTest {

   OfficeStaff paniGosia;
   MedicalStaff paniPielegniarka;
    MedicalStaff panInternista;
    MedicalStaff panPediatra;


    @BeforeEach
    void setUp() {
        // Office
        paniGosia = new OfficeStaff("o1","Gosia","Nowak", LocalDate.parse("1980-03-09"),LocalDate.parse("2000-11-01"),2700);
        // Nurse
          paniPielegniarka = new Nurse("n1","Zosia","Nowak", LocalDate.parse("1990-11-21"), LocalDate.parse("2020-10-28"),3700, "pp1");
        // Internist
         panInternista = new Internist("i1","Grzegorz", "Nowak", LocalDate.parse("1990-07-23"),LocalDate.parse("2017-09-15"), 5300, "pi2");
        // Pediatrician
         panPediatra = new Pediatrician("p1","Andrzej","Kowalski",LocalDate.parse("1990-03-03"),LocalDate.parse("2015-03-15"),7300,"pp3");
    }

    @Test
    void add() {
        paniGosia.add(paniGosia);
        paniGosia.add(paniPielegniarka);
        paniGosia.add(panInternista);
        paniGosia.add(panPediatra);
        Assertions.assertEquals(4, paniGosia.person.size());
    }

    @Test
    void printEmployeeTest() {
        paniGosia.add(panInternista);

        Assertions.assertEquals("\nName: " + "Grzegorz" + "\nSurname: " + "Nowak" +
                "\nDay Of Birth: " + LocalDate.parse("1990-07-23") + "\nDate of Employment: " + LocalDate.parse("2017-09-15") +
                "\nSalary: " + 5300 + "\nCode Employment: " + "i1" + "\n",
                "\nName: " + panInternista.name + "\nSurname: " + panInternista.surname +
                "\nDay Of Birth: " + panInternista.dayOfBirth + "\nDate of Employment: " + panInternista.dateOfEmployment +
                "\nSalary: " + (int)panInternista.salary + "\nCode Employment: " + panInternista.code_employe + "\n");
    }

    @Test
    void timeOfEmploymentTest() {
        paniGosia.add(panPediatra);
        Period tt = Period.between(panPediatra.dateOfEmployment,LocalDate.parse("2019-03-15"));
        Assertions.assertEquals( 4,tt.getYears() + tt.getMonths() / 12.0 + tt.getDays() / 365.0);
    }

    @Test
    void wholeSalaryTest() {
        paniGosia.add(paniPielegniarka);
        int months = (int) ChronoUnit.MONTHS.between(paniPielegniarka.dateOfEmployment, LocalDate.now());
        Assertions.assertEquals(3700, paniPielegniarka.salary * months);
    }

    @Test
    void getNurseTest(){
        paniGosia.add(paniPielegniarka);
        Assertions.assertEquals(paniPielegniarka, paniGosia.getNurse());
    }

    @Test
    void getInternistTest(){
        paniGosia.add(panInternista);
        Assertions.assertEquals(panInternista, paniGosia.getInternist());
    }

    @Test
    void getPediatricianTest(){
        paniGosia.add(panPediatra);
        Assertions.assertEquals(panPediatra, paniGosia.getPediatrician());
    }

    @Test
    void assignMedicTest(){
        paniGosia.add(panPediatra);
        paniGosia.add(panInternista);
        paniGosia.add(paniPielegniarka);
        int []ile = {3, 6};
        Patient patient = new Patient("Jan", "Kowalski", 2012, 3, 8, ile, "Pomiar ciśnienia, Badanie USG");
        paniGosia.assignMedic(patient, ile, LocalDate.of(patient.year, patient.month, patient.day));
        Assertions.assertEquals(1, paniGosia.getPediatrician().assignedPatients.size());
        Assertions.assertEquals(0, paniGosia.getNurse().assignedPatients.size());
        Assertions.assertEquals(0, paniGosia.getInternist().assignedPatients.size());
        Assertions.assertEquals(patient, paniGosia.getPediatrician().assignedPatients.get(panPediatra.assignedPatients.size()-1));
    }

}