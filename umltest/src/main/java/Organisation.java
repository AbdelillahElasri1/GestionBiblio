public class Organisation {
    private int orgId;
    private String name;
    private String addresse;
    private String phoneNumber;
    private String contactName;
    private String contactEmail;
    private String webSite;

    public Organisation(int orgId, String name, String addresse, String phoneNumber, String contactName, String contactEmail, String webSite) {
        this.orgId = orgId;
        this.name = name;
        this.addresse = addresse;
        this.phoneNumber = phoneNumber;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.webSite = webSite;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "orgId=" + orgId +
                ", name='" + name + '\'' +
                ", addresse='" + addresse + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", webSite='" + webSite + '\'' +
                '}';
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
