package by.epam.jmp18.domain;

import javax.persistence.Embeddable;

/**
 * Created by Vitali on 12.11.2016.
 */
@Embeddable
public class Address {
    private String street;
    private String city;
    private String house;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}
