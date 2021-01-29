package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean shouldContinue = true;
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        // Office
        OfficeStaff paniGosia = new OfficeStaff("o1","Gosia","Nowak", LocalDate.parse("1980-03-09"),LocalDate.parse("2000-11-01"),2700);
        // Nurse
        MedicalStaff paniPielegniarka = new Nurse("n1","Zosia","Nowak", LocalDate.parse("1990-11-21"), LocalDate.parse("2017-11-02"),3700, "pp1");
        // Internist
        MedicalStaff panInternista = new Internist("i1","Grzegorz", "Nowak", LocalDate.parse("1990-07-23"),LocalDate.parse("2017-09-15"), 5300, "pi2");
        // Pediatrician
        MedicalStaff panPediatra = new Pediatrician("p1","Andrzej","Kowalski",LocalDate.parse("1990-03-03"),LocalDate.parse("2015-03-15"),7300,"pp3");

        // Add to list
       // paniGosia.add(paniGosia);
        paniGosia.add(paniPielegniarka);
        paniGosia.add(panInternista);
        paniGosia.add(panPediatra);

        System.out.println("*** Welcome to Medial Clinic ***");

        while(shouldContinue) {
            System.out.println("1. Register visit");
            System.out.println("2. Calculate Salary");
            System.out.println("3. How long employee work");
            System.out.println("4. Information on employee ");
            System.out.println("5. Exit");
            System.out.println("What's your decision: ");
            int decision = scan.nextInt();

            switch (decision)
            {
                case 1 -> paniGosia.registerVisit();
                        case 2 -> paniGosia.wholeSalary();
                                case 3 -> paniGosia.printTimeOfEmployment();
                                        case 4 ->  paniGosia.printEmployee();
                                                case 5 -> shouldContinue = false;
            }
        }
    }
}
