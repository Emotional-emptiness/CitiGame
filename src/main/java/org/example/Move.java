package org.example;

import org.example.database.GsonParser;

import java.util.ArrayList;
import java.util.HashSet;

public class Move {

    private ArrayList<String> cities;  // ідея підказує щоб доставити static
    private HashSet<String> usedCities;  // ідея підказує щоб доставити static
    private String lastCity;


    public Move() {
        cities = new ArrayList<>();
        usedCities = new HashSet<>();
        GsonParser gsonParser = new GsonParser();
        cities.addAll(gsonParser.getCityNames());

    }

    public void playGame(String input) {

        // Хід гравця

//        usedCities.add(input);
//        lastCity = input;


            if (!cities.contains(input)) {
                System.out.println("інше місто");
            }


        if (check(input) || lastCity != null) {
            usedCities.add(input);
            lastCity = input;
        } // else if (input.equals("I give up")) {
//            // повідомлення в інтерфейс про програш гравця
    }
//        }


    //    private boolean check(String input) {
//        return !usedCities.contains(input) &&
//                input.startsWith(lastCity.substring(lastCity.length() - 1).toUpperCase());
//    }
    private boolean check(String input) {
        if (lastCity == null) {
            return true;
        }
        return !usedCities.contains(input) && cities.contains(input) &&
                input.toUpperCase().startsWith(lastCity.substring(lastCity.length() - 1).toUpperCase());
    } // редагував код Віталія, тому що була помилка після нажаття кнопки Skip
    // Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException: Cannot invoke "String.length()" because "this.lastCity" is null

    public String getComputerMove() {


        String nextCity = "";

        for (String city : cities) {
            if (check(city)) {
                nextCity = city;
                break;
            }
        }

        lastCity = nextCity;
        usedCities.add(nextCity);
        return nextCity;
    }

    public String skip() {
        return getComputerMove();
    }
}
