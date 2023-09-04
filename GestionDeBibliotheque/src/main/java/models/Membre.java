package models;

public class Membre {
    private Integer numberMember;
    private String name;

    public Membre(Integer numberMember, String name) {
        this.numberMember = numberMember;
        this.name = name;
    }

    public Integer getNumberMember() {
        return numberMember;
    }

    public void setNumberMember(Integer numberMember) {
        this.numberMember = numberMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Membre{" +
                "numberMember=" + numberMember +
                ", name='" + name + '\'' +
                '}';
    }
}
