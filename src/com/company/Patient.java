package com.company;

import java.time.LocalDate;
import java.util.Arrays;

public class Patient {

    String Name;
    String Surname;
    int year;
    int month;
    int day;
    String howProcedure;
    int[] ile;

    public Patient(String name, String surname, int year, int month, int day, int []ile, String howProcedure) {
        Name = name;
        Surname = surname;
        this.year = year;
        this.month = month;
        this.day = day;
        this.ile = ile;
        this.howProcedure=howProcedure;

    }


    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getHowProcedure() {
        return howProcedure;
    }

    @Override
    public String toString()
    {
        return "\nImię: " + Name + "\nNazwisko: " + Surname + "\nData Urodzenia: " + LocalDate.of(year, month, day);
    }

}
