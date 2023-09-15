public class User {
    private int UserId;
    private String name;
    private String email;
    private String password;
    private Profil profil;

    public User(int userId, String name, String email, String password, Profil profil) {
        UserId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profil = profil;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profil=" + profil +
                '}';
    }
}
