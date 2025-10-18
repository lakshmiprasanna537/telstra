package au.com.telstra.simcardactivator.model;

public class SimCardActivationResponse {

    private Long id;
    private String activationSuccessful; // matches JSON key
    private boolean success;

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getActivationSuccessful() {
        return activationSuccessful;
    }
    public void setActivationSuccessful(String activationSuccessful) {
        this.activationSuccessful = activationSuccessful;
    }

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String activationSuccessful) {
        this.activationSuccessful = activationSuccessful;
    }
}
