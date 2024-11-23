package LLD.DesignAmazon;

public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String pinCode;
    private String country;

    public Address(String streetAddress, String city, String state, String pinCode, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.country = country;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
