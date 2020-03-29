package geographic.domain;

/**
 * Address class
 */
public class Address {

    /**
     * Street name
     */
    private String streetName;

    /**
     * Street number
     */
    private String streetNumber;

    /**
     * Street postal code
     */
    private String postalCode;

    /**
     * City of address
     */
    private City city;

    /**
     * First line in address details
     */
    private String lineOne;

    /**
     * Second line in address details
     */
    private String lineTwo;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getLineOne() {
        return lineOne;
    }

    public void setLineOne(String lineOne) {
        this.lineOne = lineOne;
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public void setLineTwo(String lineTwo) {
        this.lineTwo = lineTwo;
    }
}
