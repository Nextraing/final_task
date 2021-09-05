package users;

import utils.PropertiesLoader;

import java.io.File;
import java.util.Objects;

public class Candidate {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String contactNo;
    private String resumePath;

    public Candidate() {

        PropertiesLoader propertiesLoader = new PropertiesLoader();

        this.firstName = propertiesLoader.getCandidateProperty("candidate.firstName");
        this.middleName = propertiesLoader.getCandidateProperty("candidate.middleName");
        this.lastName = propertiesLoader.getCandidateProperty("candidate.lastName");
        this.email = propertiesLoader.getCandidateProperty("candidate.email");
        this.contactNo = propertiesLoader.getCandidateProperty("candidate.contactNo");
        this.resumePath = new File(propertiesLoader.getCandidateProperty("candidate.resumePath"))
                .getAbsolutePath();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidate)) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(getFirstName(), candidate.getFirstName()) &&
                Objects.equals(getMiddleName(), candidate.getMiddleName()) &&
                Objects.equals(getLastName(), candidate.getLastName()) &&
                getEmail().equals(candidate.getEmail()) &&
                Objects.equals(getContactNo(), candidate.getContactNo()) &&
                Objects.equals(getResumePath(), candidate.getResumePath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getMiddleName(), getLastName(),
                getEmail(), getContactNo(), getResumePath());
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", resumePath='" + resumePath + '\'' +
                '}';
    }
}
