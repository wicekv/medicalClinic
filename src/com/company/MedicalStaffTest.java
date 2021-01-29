package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MedicalStaffTest {

    MedicalStaff paniPielegniarka;
    MedicalStaff panInternista;
    MedicalStaff panPediatra;


    @BeforeEach
    void setUp() {
        // Nurse
        paniPielegniarka = new Nurse("n1","Zosia","Nowak", LocalDate.parse("1990-11-21"), LocalDate.parse("2020-10-28"),3700, "pp1");
        // Internist
        panInternista = new Internist("i1","Grzegorz", "Nowak", LocalDate.parse("1990-07-23"),LocalDate.parse("2017-09-15"), 5300, "pi2");
        // Pediatrician
        panPediatra = new Pediatrician("p1","Andrzej","Kowalski",LocalDate.parse("1990-03-03"),LocalDate.parse("2015-03-15"),7300,"pp3");
    }

    @Test
    void assignPatientTest(){
        int []ile = {3, 6};
        Patient patient = new Patient("Jan", "Kowalski", 2012, 3, 8, ile, "Pomiar ciśnienia, Badanie USG");
        paniPielegniarka.assignPatient(patient);
        paniPielegniarka.assignPatient(patient);
        panInternista.assignPatient(patient);
        panPediatra.assignPatient(patient);
        panPediatra.assignPatient(patient);
        panPediatra.assignPatient(patient);
        Assertions.assertEquals(3, panPediatra.assignedPatients.size());
        Assertions.assertEquals(1, panInternista.assignedPatients.size());
        Assertions.assertEquals(2, paniPielegniarka.assignedPatients.size());
    }
}
