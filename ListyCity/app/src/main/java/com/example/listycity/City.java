package com.example.listycity;

public class City implements Comparable<City> {
    private String name;
    private String province;

    /**
     * Constructs a new City object with the given name and province.
     *
     * @param name     The name of the city.
     * @param province The province of the city.
     */
    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }

    /**
     * Gets the name of the city.
     *
     * @return The name of the city.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the city.
     *
     * @param name The new name of the city.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the province of the city.
     *
     * @return The province of the city.
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the province of the city.
     *
     * @param province The new province of the city.
     */
    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public int compareTo(City city) {
        return this.name.compareTo(city.getName());
    }
}
