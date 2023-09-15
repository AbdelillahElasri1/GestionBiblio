import java.util.Date;

public class Phase {
    private int phaseId;
    private String Label;
    private String description;
    private Date startDate;
    private Date endDate;
    private double pourcentage;
    private BillingStatus billingStatus;
    private PaymentStatus paymentStatus;
    private Project project;

    public Phase(int phaseId, String label, String description, Date startDate, Date endDate, double pourcentage, BillingStatus billingStatus, PaymentStatus paymentStatus, Project project) {
        this.phaseId = phaseId;
        Label = label;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pourcentage = pourcentage;
        this.billingStatus = billingStatus;
        this.paymentStatus = paymentStatus;
        this.project = project;
    }

    public int getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(int phaseId) {
        this.phaseId = phaseId;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public BillingStatus getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(BillingStatus billingStatus) {
        this.billingStatus = billingStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Phase{" +
                "phaseId=" + phaseId +
                ", Label='" + Label + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", pourcentage=" + pourcentage +
                ", billingStatus=" + billingStatus +
                ", paymentStatus=" + paymentStatus +
                ", project=" + project +
                '}';
    }
}
