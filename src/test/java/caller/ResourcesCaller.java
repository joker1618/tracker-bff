package caller;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import xxx.joker.libs.core.files.JkFiles;

import java.nio.file.Paths;

import static xxx.joker.libs.core.utils.JkConsole.display;

public class ResourcesCaller {

    @Test
    public void getFlag() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<byte[]> response = restTemplate.exchange(
                "http://localhost:666/wrc/resources/flag?countryName=United Kingdom",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<byte[]>(){});
        JkFiles.writeFile(Paths.get("fedefiles.png"), response.getBody());
    }

}
