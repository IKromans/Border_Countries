package co.bo.bordercountries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class BorderCountriesApplicationTests {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    BorderCountriesService borderCountriesService;

    @Test
    void testCorrectCountryCode() {
        String countryCode = "ca";

        List<String> expected = new ArrayList<>();
        expected.add("United States");

        Country country = new Country();

        Mockito.when(restTemplate.getForEntity("https://date.nager.at/api/v3/CountryInfo/ca", Country.class))
                .thenReturn(new ResponseEntity<>(country, HttpStatus.OK));
        List<String> actual = borderCountriesService.getBorderCountries(countryCode);

        Assertions.assertEquals(expected, actual);
    }
}