package Dao;

import models.Membre;

import java.util.List;

public interface MembreDaoInterface {
    void saveMember(Membre membre);
    void updateMember(Membre membre);
    void deleteMember(int numberMember);
    Membre getMemberByNumMember(int memberId);
    List<Membre> getAllMembers();

}
