package com.company;

import java.util.ArrayList;
import java.util.List;

public class Procedure {
    List<String> allProcedures = new ArrayList<>();



    public Procedure() {
            allProcedures.add("Zastrzyk");
            allProcedures.add("Pomiar wagi");
            allProcedures.add("Pomiar ciśnienia");
            allProcedures.add("Pobieranie Krwi");
            allProcedures.add("Badanie Ogolne"); // tylko lekarz
            allProcedures.add("Badanie USG"); // tylko lekarz
            allProcedures.add("Wypisanie Recepty"); // tylko lekarz
    }
}
