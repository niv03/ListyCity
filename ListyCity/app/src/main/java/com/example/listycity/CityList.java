package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist.
     *
     * @param city The city to add.
     * @throws IllegalArgumentException If the city already exists in the list.
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists in the list.");
        }
        cities.add(city);
    }

    /**
     * Checks if a city is present in the list.
     *
     * @param city The city to check for.
     * @return True if the city is in the list, false otherwise.
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Removes a city from the list if it exists. Otherwise, throws an exception.
     *
     * @param city The city to remove.
     * @throws IllegalArgumentException If the city is not in the list.
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found in the list.");
        }
        cities.remove(city);
    }

    /**
     * Returns the number of cities in the list.
     *
     * @return The number of cities in the list.
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * Returns a sorted list of cities.
     *
     * @return The sorted list of cities.
     */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities); // Create a copy to avoid modifying the original list.
        Collections.sort(list);
        return list;
    }
}
