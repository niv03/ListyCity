package com.example.listycity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }


    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });

    }
    @Test
    public void testDelete() {
        CityList cityList = new CityList();
        City city1 = new City("San Francisco", "California");
        City city2 = new City("Seattle", "Washington");

        cityList.add(city1);
        cityList.add(city2);

        assertTrue(cityList.hasCity(city1)); // City1 should be in the list

        // Delete city1
        cityList.delete(city1);

        assertFalse(cityList.hasCity(city1)); // City1 should no longer be in the list
        assertEquals(1, cityList.countCities()); // There should be only 1 city left

        // Try to delete city1 again, it should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });

        // Try to delete a city not in the list, it should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(new City("Chicago", "Illinois"));
        });
    }

    @Test
    public void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());

        cityList.add(new City("Boston", "Massachusetts"));
        assertEquals(1, cityList.countCities());

        cityList.add(new City("Dallas", "Texas"));
        assertEquals(2, cityList.countCities());
    }


    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = new CityList();
        City city1 = new City("New York", "New York");
        City city2 = new City("Los Angeles", "California");

        cityList.add(city1);
        cityList.add(city2);

        assertTrue(cityList.hasCity(city1)); // City1 should be in the list
        assertTrue(cityList.hasCity(city2)); // City2 should be in the list
        assertFalse(cityList.hasCity(new City("Chicago", "Illinois"))); // City not in the list
    }





}