package co.bo.bordercountries;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
public class BorderCountriesService {

    private final ApiData apiData;

    public BorderCountriesService(ApiData apiData) {
        this.apiData = apiData;
    }

    public List<String> getBorderCountries(String countryCode) {
        Country rawData = apiData.getApiData(countryCode);
        if (rawData != null) {
            Country[] borders = rawData.getBorders();
            return Arrays.stream(borders).map(Country::getCommonName).toList();
        } else {
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Wrong input!!!");
        }
    }
}