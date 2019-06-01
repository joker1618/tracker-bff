package caller;

import com.stats.tracker.be.datalayer.wrc.entities.WrcCar;
import com.stats.tracker.be.datalayer.wrc.entities.WrcCountry;
import com.stats.tracker.be.datalayer.wrc.entities.WrcDriver;
import com.stats.tracker.be.restModel.RestResponse;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import xxx.joker.libs.core.format.JkOutput;
import xxx.joker.libs.core.lambdas.JkStreams;

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
        display(JkOutput.formatColl(response.getBody()));
    }
    @Test
    public void showDrivers() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<WrcDriver>> response = restTemplate.exchange(
                "http://localhost:666/wrc/info/drivers",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WrcDriver>>(){});
        display(JkOutput.formatColl(response.getBody()));
    }
//    public <T> void callUrl(String url, T elemType) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<List<T>> response = restTemplate.exchange(
//                "http://localhost:666/wrc/info/drivers",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<T>>(){});
//        display(JkOutput.formatColl(response.getBody()));
//    }
    @Test
    public void showCountries() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<WrcCountry>> response = restTemplate.exchange(
                "http://localhost:666/wrc/info/countries",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WrcCountry>>(){});
        display(JkOutput.formatColl(response.getBody()));
    }

    @Ignore
    @Test
    public void rr() {
//        RestTemplate restTemplate = new RestTemplateBuilder()
//                .errorHandler(new RestTemplateResponseErrorHandler())
//                .build();
        RestTemplate restTemplate = new RestTemplate();
        List res = restTemplate.getForObject("http://localhost:666/wrc/config/a", List.class);
        display(res);
//        RestResponse fob = restTemplate.getForObject("http://localhost:666/wrc/config/e", RestResponse.class);
//        display(fob);
        ResponseEntity e = restTemplate.getForEntity("http://localhost:666/wrc/config/b", List.class);
        display(e.toString());
        ResponseEntity<List> e1 = restTemplate.getForEntity("http://localhost:666/wrc/config/f", List.class);
        display(e1.toString());
        ResponseEntity<List> e2 = restTemplate.getForEntity("http://localhost:666/wrc/config/f", List.class);
        display(e1.toString());
    }
}
