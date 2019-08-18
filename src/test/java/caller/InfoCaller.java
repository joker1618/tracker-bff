package caller;

import com.stats.tracker.be.datalayer.wrc6.entities.*;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import xxx.joker.libs.core.format.JkOutput;

import java.util.List;

import static xxx.joker.libs.core.utils.JkConsole.display;

public class InfoCaller {
    
    private static String BASE_URL = "http://localhost:666/bomber/wrc6";

    @Test
    public void showCars() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Wrc6Car>> response = restTemplate.exchange(
                BASE_URL + "/info/cars",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Wrc6Car>>(){});
        List<Wrc6Car> body = response.getBody();
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(body));
    }


    @Test
    public void showRallies() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Wrc6Rally>> response = restTemplate.exchange(
                BASE_URL + "/info/rallies",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Wrc6Rally>>(){});
        List<Wrc6Rally> body = response.getBody();
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(body));
    }

    @Test
    public void showDrivers() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Wrc6Driver>> response = restTemplate.exchange(
                BASE_URL + "/info/drivers",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Wrc6Driver>>(){});
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showRaceTimes() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Wrc6RaceTime>> response = restTemplate.exchange(
                BASE_URL + "/info/raceTimes",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Wrc6RaceTime>>(){});
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showCountries() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Wrc6Country>> response = restTemplate.exchange(
                BASE_URL + "/info/countries",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Wrc6Country>>(){});
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showGroundTypes() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Wrc6GroundType>> response = restTemplate.exchange(
                BASE_URL + "/info/surfaces/groundTypes",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Wrc6GroundType>>(){});
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showWeathers() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Wrc6Weather>> response = restTemplate.exchange(
                BASE_URL + "/info/weathers",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Wrc6Weather>>(){});
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showStages() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Wrc6Stage>> response = restTemplate.exchange(
                BASE_URL + "/info/stages",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Wrc6Stage>>(){});
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showSurfaces() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Wrc6Surface>> response = restTemplate.exchange(
                BASE_URL + "/info/surfaces",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Wrc6Surface>>(){}
        );
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showMatches() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Wrc6Match>> response = restTemplate.exchange(
                BASE_URL + "/info/matches",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Wrc6Match>>(){}
        );
        display(response);
        display(response.getBody());
        display(JkOutput.formatObject(response.getBody()));
    }


}
