package caller;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static xxx.joker.libs.core.utils.JkConsole.display;

public class DevCaller {

    private static String BASE_URL = "http://localhost:666/bomber/wrc6";

    @Test
    public void initJpa() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(
                BASE_URL + "/dev/initJpa",
                String.class
        );
        display("initJpa done  -->  {}", response.getBody());
    }


//    @Test
//    public void jpaToRepo() {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.getForEntity(
//                "http://localhost:666/wrc/dev/jpaToRepo",
//                String.class
//        );
//        display("jpaToRepo done  -->  {}", response.getBody());
//    }




}
