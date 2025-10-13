package au.com.telstra.simcardactivator.model;

public class SimCardActivationRequest {

    private String iccid;
    private String customerEmail;

    public SimCardActivationRequest() {
    }
    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "SimCardActivationRequest{" +
                "iccid='" + iccid + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }
}
