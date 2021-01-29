package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OfficeStaff extends Employee
{
    ArrayList<Employee> person;
    List<Patient> patients = new ArrayList<>();
    Procedure procedures;


    public OfficeStaff(String code_employe, String name, String surname, LocalDate dayOfBirth, LocalDate dateOfEmployment, float salary)
    {
        super(code_employe, name, surname, dayOfBirth, dateOfEmployment, salary);
        this.person = new ArrayList<Employee>();
        this.procedures = new Procedure();
    }

    public void add(Employee employee)
    {
        person.add(employee);
    }

    public void registerVisit() {

        try {
            Scanner scan = new Scanner(System.in);

            System.out.println("What's your name: ");
            String namePatient = scan.nextLine();

            System.out.println("What's your surname: ");
            String surnamePatient = scan.nextLine();

            System.out.println("What's your year of birth ");
            int year = scan.nextInt();
            if (year > LocalDate.now().getYear() || year < 1900) {
                throw new IllegalArgumentException();
            }
            System.out.println("What's your month of birth");
            int month = scan.nextInt();
            if(month < 1 || month > 12)
            {
                throw new IllegalArgumentException();
            }

            System.out.println("What's your day of birth");
            int day = scan.nextInt();
            if(day < 1 || day > 31)
            {
                throw new IllegalArgumentException();
            }

            System.out.println("How many procedures: ");
            int many = scan.nextInt();
            if(many < 1 || many > 7){
                throw new IllegalArgumentException();
            }

            int[] tab = new int[many];
            String whatProcedure = " ";
            int x;
            for (int i = 0; i < many; i++) {
                System.out.println("Add Procedure: ");
                x = scan.nextInt();

                if( x < 1 || x > procedures.allProcedures.size())
                {
                    throw new ArrayIndexOutOfBoundsException();
                }
                else
                {
                    tab[i] = x;
                    whatProcedure += procedures.allProcedures.get(x-1) + ", ";
                }
            }

            Patient patient = new Patient(namePatient, surnamePatient, year, month, day, tab, whatProcedure);
            assignMedic(patient, tab, LocalDate.of(year, month, day));
            patients.add(patient);
            System.out.println();
        }catch(IllegalArgumentException e)
        {
            System.out.println("Invalid date");
        }catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid number of procedures");
        }
    }

    public void assignMedic(Patient patient, int[] tab, LocalDate dateOfBirth){
        for (int j : tab) {
            if (!getNurse().procedureNurse.contains(procedures.allProcedures.get(j))) {
                if (dateOfBirth.plusYears(18).compareTo(LocalDate.now()) <= 0) {
                    getInternist().assignPatient(patient);
                } else {
                    getPediatrician().assignPatient(patient);
                }
                return;
            }
        }
        getNurse().assignPatient(patient);
    }

    public void printEmployee() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Employee Code: ");
        String employeeCode = scan.nextLine();
        boolean flag = false;

        try {
            for (int i = 0; i < person.size(); i++) {
                if (employeeCode.equals(person.get(i).code_employe)) {
                    System.out.println("\nName: " + person.get(i).name + "\nSurname: " + person.get(i).surname +
                            "\nDay Of Birth: " + person.get(i).dayOfBirth + "\nDate of Employment: " + person.get(i).dateOfEmployment +
                            "\nSalary: " + person.get(i).salary + "\nCode Employment: " + person.get(i).code_employe + "\n");
                    flag = true;
                }

            }if(!flag){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e)
        {
            System.out.println("Incorrect data");
        }
    }

    public void printTimeOfEmployment() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Employee Code: ");
        String employeeCode = scan.nextLine();
        boolean flag = false;
        try {
            for (int i = 0; i < person.size(); i++) {
                if (employeeCode.equals(person.get(i).code_employe)) {
                    Period test = Period.between(person.get(i).dateOfEmployment, LocalDate.now());
                    System.out.printf("Your work in this job %.2f years.\n",
                            test.getYears() + test.getMonths() / 12.0 + test.getDays() / 365.0);
                    flag = true;
                }
            }
            if (!flag) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e)
        {
            System.out.println("Incorrect data");
        }
    }

    public void wholeSalary() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Employee Code: ");
        String employeeCode = scan.nextLine();
        boolean flag = false;
        try {
            for (int i = 0; i < person.size(); i++) {
                if (employeeCode.equals(person.get(i).code_employe)) {
                    int months = (int) ChronoUnit.MONTHS.between(person.get(i).dateOfEmployment, LocalDate.now());
                    float cash = person.get(i).salary * months;
                    System.out.println("Salary: " + cash);
                    flag = true;
                }
            }
            if(!flag) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e)
        {
            System.out.println("Incorrect data");
        }
    }

    public Nurse getNurse(){
        for (Employee employee : person) {
            if (employee instanceof Nurse) {
                return (Nurse) employee;
            }
        }
        return null;
    }

    public Internist getInternist(){
        for (Employee employee : person) {
            if (employee instanceof Internist) {
                return (Internist) employee;
            }
        }
        return null;
    }

    public Pediatrician getPediatrician(){
        for (Employee employee : person) {
            if (employee instanceof Pediatrician) {
                return (Pediatrician) employee;
            }
        }
        return null;
    }

    public ArrayList<Employee> getPerson() {
        return person;
    }

    public List<Patient> getPatients() {
        return patients;
    }
}
