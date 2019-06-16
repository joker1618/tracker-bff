package caller;

import com.stats.tracker.be.datalayer.wrc.entities.*;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import xxx.joker.libs.core.format.JkOutput;

import java.util.List;

import static xxx.joker.libs.core.utils.JkConsole.display;

public class InfoCaller {

    @Test
    public void showCars() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<WrcCar>> response = restTemplate.exchange(
                "http://localhost:666/wrc/info/cars",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WrcCar>>(){});
        List<WrcCar> body = response.getBody();
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(body));
    }


    @Test
    public void showRallies() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<WrcRally>> response = restTemplate.exchange(
                "http://localhost:666/wrc/info/rallies",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WrcRally>>(){});
        List<WrcRally> body = response.getBody();
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(body));
    }

    @Test
    public void s() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.getForEntity(
                "http://localhost:666/wrc/config/c",
                Object.class);
        display(response);
        display(response.getBody());

        ResponseEntity<WrcWeather> response1 = restTemplate.exchange(
                "http://localhost:666/wrc/config/c",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<WrcWeather>(){});
        display(response1);
        display(response1.getBody());
    }

    @Test
    public void showDrivers() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<WrcDriver>> response = restTemplate.exchange(
                "http://localhost:666/wrc/info/drivers",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WrcDriver>>(){});
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showRaceTimes() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<WrcRaceTime>> response = restTemplate.exchange(
                "http://localhost:666/wrc/info/raceTimes",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WrcRaceTime>>(){});
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showCountries() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<WrcCountry>> response = restTemplate.exchange(
                "http://localhost:666/wrc/info/countries",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WrcCountry>>(){});
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showGroundTypes() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<WrcGroundType>> response = restTemplate.exchange(
                "http://localhost:666/wrc/info/surfaces/groundTypes",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WrcGroundType>>(){});
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showWeathers() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<WrcWeather>> response = restTemplate.exchange(
                "http://localhost:666/wrc/info/weathers",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WrcWeather>>(){});
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showStages() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<WrcStage>> response = restTemplate.exchange(
                "http://localhost:666/wrc/info/stages",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WrcStage>>(){});
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showSeasons() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<WrcSeason>> response = restTemplate.exchange(
                "http://localhost:666/wrc/info/seasons",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WrcSeason>>(){});
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showSurfaces() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<WrcSurface>> response = restTemplate.exchange(
                "http://localhost:666/wrc/info/surfaces",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WrcSurface>>(){}
        );
        display(response);
        display(response.getBody());
        display(JkOutput.formatColl(response.getBody()));
    }

    @Test
    public void showMatches() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<WrcMatch>> response = restTemplate.exchange(
                "http://localhost:666/wrc/info/matches",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WrcMatch>>(){}
        );
        display(response);
        display(response.getBody());
        display(JkOutput.formatObject(response.getBody()));
    }
    @Test
    public void showMatch0() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WrcMatch> response = restTemplate.getForEntity("http://localhost:666/wrc/info/match0", WrcMatch.class);
        display(response);
        display(response.getBody());
        display(JkOutput.formatObject(response.getBody()));
    }


}
