package au.com.telstra.simcardactivator.Service;

import au.com.telstra.simcardactivator.Entity.SimCardActivationRecord;
import au.com.telstra.simcardactivator.Repository.SimCardActivationRepository;
import au.com.telstra.simcardactivator.model.SimCardActivationResponse;
import au.com.telstra.simcardactivator.model.SimCardActivationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SimCardActivationService {

    @Autowired
    private SimCardActivationRepository simCardActivationRepository;
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
            SimCardActivationRecord simCardActivationRecord = new SimCardActivationRecord(request.getIccid(),request.getCustomerEmail());
            simCardActivationRecord.setActive(Boolean.TRUE);
            simCardActivationRepository.save(simCardActivationRecord);
            return "Activation succeeded";
        } else {
            return "Activation failed";
        }
    }

    public ResponseEntity<SimCardActivationRecord> getSimStatus(long id) {
        return simCardActivationRepository.findById(id)
                .map(record -> ResponseEntity.ok(record))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
