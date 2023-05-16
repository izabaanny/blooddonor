package BloodDonation.blood.entity;

import javax.persistence.*;

@Entity
@Table(name = "admin")

public class Admin {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "fName")
    private String fName;
    @Column(name = "lName")
    private String lName;
    @Column(name = "email")
    private String email;
    @Column(name = "contact")
    private String contact;
    @Column(name = "aContact")
    private String aContact;
    @Column(name = "bloodGroup")
    private String bloodGroup;
    @Column(name = "country")
    private String country;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;

    public Admin() {
    }

    public Admin(String fName, String lName, String email, String contact, String aContact, String bloodGroup,
                 String country, String state, String city) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.contact = contact;
        this.aContact = aContact;
        this.bloodGroup = bloodGroup;
        this.country = country;
        this.state = state;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getaContact() {
        return aContact;
    }

    public void setaContact(String aContact) {
        this.aContact = aContact;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString(){
        return "BloodDonor [fName=" + fName + ", lName=" + lName + ", email=" + email + ", contact=" + contact
                + ", aContact=" + aContact + ", bloodGroup=" + bloodGroup + ", country=" + country + ", state=" + state
                + ", city=" + city + "]";
    }

}


