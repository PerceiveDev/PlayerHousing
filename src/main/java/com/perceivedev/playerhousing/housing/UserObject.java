package com.perceivedev.playerhousing.housing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 9/30/16.
 */
public class UserObject {
    private List<House> houses = new ArrayList<House>();

    public UserObject() {
    }

    public void addHouse(House house) {
        houses.add(house);
    }

    public void removeHouse(House house) {
        houses.remove(house);
    }

    public List<House> returnHouses() {
        return houses;
    }

}
