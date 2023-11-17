package tn.esprit.spring.khaddem.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.khaddem.KhaddemApplication;
import tn.esprit.spring.khaddem.entities.*;

import tn.esprit.spring.khaddem.repositories.EquipeRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = KhaddemApplication.class)
class EquipeServiceImplTest {



    private static final Logger log = LoggerFactory.getLogger(EquipeServiceImplTest.class);

    @Autowired
    IEquipeService equipeServicee;
    @Autowired
    private DetailsEquipeServiceImp detailsEquipeService;
    @Autowired
    EquipeRepository equipeRepository;


/*  @Test
    void addEquipe(){
        Equipe equipeToSave = Equipe.builder()
                .nomEquipe("Handball")
                .niveau(Niveau.JUNIOR)
                .build();
         //Act : enregistrer l'equipe créé en appelant la methode serviceEquipe
        Equipe savedEquipe = equipeServicee.addEquipe(equipeToSave);

        DetailEquipe detailsEqToSave = DetailEquipe.builder()
                .salle(12)
                .equipe(savedEquipe)
                .thematique("Hand")
                .build();
        DetailEquipe savedDetailEquipe = detailsEquipeService.addDetailsEquipe(detailsEqToSave);

       log.info("L'équipe {} de niveau {} est ajoutée", savedEquipe.getNomEquipe(), savedEquipe.getNiveau());
        //s'assurer que  l'équipe enregistrée correspondent au l'équipe créée
        Assertions.assertNotNull(savedDetailEquipe);
        Assertions.assertNotNull(savedEquipe);
        assertEquals(savedEquipe.getNomEquipe(), equipeToSave.getNomEquipe());
        assertEquals(savedEquipe.getNiveau(),equipeToSave.getNiveau());

        equipeServicee.removeEquipe(savedEquipe.getIdEquipe());


     }*/





}