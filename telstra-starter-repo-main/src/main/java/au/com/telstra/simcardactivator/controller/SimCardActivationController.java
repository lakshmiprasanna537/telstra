package au.com.telstra.simcardactivator.controller;


import au.com.telstra.simcardactivator.Entity.SimCardActivationRecord;
import au.com.telstra.simcardactivator.Service.SimCardActivationService;
import au.com.telstra.simcardactivator.model.SimCardActivationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimCardActivationController {

    @Autowired
    public SimCardActivationService simCardActivationService;

    @PostMapping("/activate")
    public String activateSim(@RequestBody SimCardActivationRequest simCardActivationRequest){

        return simCardActivationService.activateSim(simCardActivationRequest);
    }

    @GetMapping("/getSimStatus")
    public SimCardActivationRecord getSimStatus(@RequestParam("id") long id){
        return simCardActivationService.getSimStatus(id).getBody();
    }
}