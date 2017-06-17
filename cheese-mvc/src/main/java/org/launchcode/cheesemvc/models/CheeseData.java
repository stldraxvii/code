package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

/**
 * Created by Matt on 6/5/2017.
 */
public class CheeseData {

    static ArrayList<Cheese> cheeses = new ArrayList<>();

    public static ArrayList<Cheese> getall() {
        return cheeses;
    }

    public static void add(Cheese newCheese) {
        cheeses.add(newCheese);
    }

    public static void remove(int id) {
        Cheese cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);
    }

    public static Cheese getById(int id) {
        Cheese theCheese = null;

        for (Cheese candidateCheese : cheeses) {
            if (candidateCheese.getCheeseId() == id) {
                theCheese = candidateCheese;
            }
        }
        return theCheese;
    }
}
