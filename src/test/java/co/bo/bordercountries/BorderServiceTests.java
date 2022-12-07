package co.bo.bordercountries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BorderServiceTests {

    @Mock
    ApiData apiData;

    @InjectMocks
    BorderCountriesService borderCountriesService;

    @Test
    void testWhenResponseIsNull() {

        String countryCode = "eee";

        Mockito.when(apiData.getApiData(countryCode))
                .thenThrow(new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED));

        Assertions.assertThrows(ResponseStatusException.class, () -> borderCountriesService.getBorderCountries(countryCode));
    }

    @Test
    void testWhenResponseIsData() {

        String countryCode = "av";
        Country[] testBordersCountries = new Country[]{new Country("Italy", null)};
        Country testCountry = new Country("Vatican City", testBordersCountries);
        Mockito.when(apiData.getApiData(countryCode))
                .thenReturn(testCountry);
        List<String> actual = borderCountriesService.getBorderCountries(countryCode);
        List<String> expected = Arrays.stream(testBordersCountries).map(Country::getCommonName).toList();
        Assertions.assertEquals(expected, actual);
    }
}
