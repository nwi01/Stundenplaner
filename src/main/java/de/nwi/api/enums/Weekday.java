package de.nwi.api.enums;

/**
 * Created by niels on 24.09.2015.
 */
public enum Weekday {
    MONDAY("Montag"),
    TUESDAY("Dienstag"),
    WEDNESDAY("Mittwoch"),
    THURSDAY("Donnerstag"),
    FRIDAY("Freitag");

    private String name;

    public String getName(){
        return name;
    }

    Weekday(String name){
        this.name = name;
    }
}
