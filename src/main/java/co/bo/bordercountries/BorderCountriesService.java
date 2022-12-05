package co.bo.bordercountries;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
public class BorderCountriesService {

    RestTemplate restTemplate = new RestTemplate();

    public List<String> getBorderCountries(String countryCode) {
        Country rawData = restTemplate.getForObject("https://date.nager.at/api/v3/CountryInfo/" + countryCode, Country.class);
        if (rawData != null) {
            List<Country> borderCountriesList = Arrays.asList(rawData.getBorders());
            return borderCountriesList.stream().map(Country::getCommonName).toList();
        } else {
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Wrong input!!!");
        }
    }
}
