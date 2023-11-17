package tn.esprit.spring.khaddem.services;

import tn.esprit.spring.khaddem.entities.Equipe;

import java.util.List;

public interface IEquipeService {

    List<Equipe> retrieveAllEquipes();

    Equipe  addEquipe(Equipe  e);
    public void removeEquipe(Integer idEquipe);
    Equipe updateEquipe (Equipe  e);

    Equipe retrieveEquipe (Integer idEquipe);

    public void evoluerEquipes();

}
