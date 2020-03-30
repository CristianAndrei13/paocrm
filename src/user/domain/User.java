package user.domain;

import geographic.domain.Address;

/**
 * User domain
 */
public class User extends AbstractUser {

    /**
     * First name of user
     */
    private String firstName;

    /**
     * Last name of user
     */
    private String lastName;

    /**
     * Email address of user
     */
    private String email;

    /**
     * Phone number of user
     */
    private String phone;

    /**
     * National identification number of user
     */
    private String nationalIdentificationNumber;

    /**
     * Address of user
     */
    private Address address;

    @Override
    public String toString() {
        return this.username != null ? this.username : ("#" + this.id + " " + this.firstName + " " + this.lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationalIdentificationNumber() {
        return nationalIdentificationNumber;
    }

    public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
