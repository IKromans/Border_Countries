package co.bo.bordercountries;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiData {

    private final RestTemplate restTemplate = new RestTemplate();

    public Country getApiData(String countryCode) {
        return restTemplate.getForObject("https://date.nager.at/api/v3/CountryInfo/" + countryCode, Country.class);
    }
}
