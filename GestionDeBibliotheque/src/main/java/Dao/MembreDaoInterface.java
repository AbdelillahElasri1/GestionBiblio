package Dao;

import models.Membre;

import java.util.List;

public interface MembreDaoInterface {
    Membre saveMember(Membre membre);
    Membre updateMember(Membre membre);
    void deleteMember(int numberMember);
    Membre getMemberByNumMember(int memberId);
    List<Membre> getAllMembers();

}
