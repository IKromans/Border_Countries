package co.bo.bordercountries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/myapp")
public class BorderController {

    private final BorderCountriesService borderCountriesService;

    public BorderController(BorderCountriesService borderService) {
        this.borderCountriesService = borderService;
    }

    @GetMapping("/countries/{countryCode}")
    public List<String> getBorderCountries(@PathVariable String countryCode) {
        return borderCountriesService.getBorderCountries(countryCode);
    }
}