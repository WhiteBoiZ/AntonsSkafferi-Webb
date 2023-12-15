package se.miun.whiteboiz.entities;

import jakarta.persistence.Embeddable;

import java.util.ArrayList;


public class DaySelection extends LunchEntity {
    private ArrayList<String> days;
}
