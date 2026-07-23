public class Candidate {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Candidate(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Candidate Information: " + "\n" + "First Name: " + firstName +
                                           "\n" + "Last Name: " + lastName +
                                           "\n" + "Email: " + email +
                                           "\n" + "Phone Number: " + phoneNumber;
    }

    static void main() {
        Candidate c = new Candidate("Erigert", "Zaimi", "erigert.zaimi", "0684206646");
       System.out.println( c.toString());
    }
}
