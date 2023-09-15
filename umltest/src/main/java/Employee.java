public class Employee {
    private int employeId;
    private String name;
    private String matricule;
    private String email;
    private String phoneNumber;
    private Profil profil;

    public Employee(int employeId, String name, String matricule, String email, String phoneNumber, Profil profil) {
        this.employeId = employeId;
        this.name = name;
        this.matricule = matricule;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profil = profil;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeId=" + employeId +
                ", name='" + name + '\'' +
                ", matricule='" + matricule + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", profil=" + profil +
                '}';
    }

    public int getEmployeId() {
        return employeId;
    }

    public void setEmployeId(int employeId) {
        this.employeId = employeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }
}
