package au.com.telstra.simcardactivator.model;

public class SimCardActivationResponse {

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private boolean success;
}
