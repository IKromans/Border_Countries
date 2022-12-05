package co.bo.bordercountries;

import java.io.Serializable;

public class Country implements Serializable {

    private String commonName;
    private Country[] borders;

    public Country() {
    }

    public Country(String commonName, Country[] borders) {
        this.commonName = commonName;
        this.borders = borders;
    }

    public String getCommonName() {
        return commonName;
    }

    public Country[] getBorders() {
        return borders;
    }
}
