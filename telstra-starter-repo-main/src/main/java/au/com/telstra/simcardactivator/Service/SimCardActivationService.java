package au.com.telstra.simcardactivator.Service;

import au.com.telstra.simcardactivator.model.SimCardActivationResponse;
import au.com.telstra.simcardactivator.model.SimCardActivationRequest;
import au.com.telstra.simcardactivator.model.SimCardActivationResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SimCardActivationService {

    private final WebClient webClient = WebClient.create("http://localhost:8444");

    public String activateSim(SimCardActivationRequest request) {
        // Send POST request to actuator
        SimCardActivationResponse response = webClient.post()
                .uri("/actuate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"iccid\":\"" + request.getIccid() + "\"}") // send JSON manually
                .retrieve()
                .bodyToMono(SimCardActivationResponse.class)
                .block(); // block to wait for response

        if (response != null && response.isSuccess()) {
            return "Activation succeeded";
        } else {
            return "Activation failed";
        }
    }
}
