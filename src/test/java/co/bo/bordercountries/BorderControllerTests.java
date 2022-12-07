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
import java.util.List;

@ExtendWith(MockitoExtension.class)
class BorderControllerTests {

    @Mock
    BorderCountriesService borderCountriesService;

    @InjectMocks
    BorderController borderController;

    @Test
    void testCorrectCountryCode() {
        String countryCode = "ca";

        List<String> expected = new ArrayList<>();
        expected.add("United States");

        Mockito.when(borderCountriesService.getBorderCountries(countryCode))
                .thenReturn(expected);
        List<String> actual = borderController.getBorderCountries(countryCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIncorrectCountryCode() {
        String countryCode = "cca";

        Mockito.when(borderCountriesService.getBorderCountries(countryCode))
                .thenThrow(new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED));

        Assertions.assertThrows(ResponseStatusException.class, () -> borderController.getBorderCountries(countryCode));
    }
}