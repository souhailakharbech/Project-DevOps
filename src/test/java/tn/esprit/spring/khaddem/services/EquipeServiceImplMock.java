package tn.esprit.spring.khaddem.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.khaddem.entities.Contrat;
import tn.esprit.spring.khaddem.entities.Equipe;
import tn.esprit.spring.khaddem.entities.Etudiant;
import tn.esprit.spring.khaddem.entities.Niveau;
import tn.esprit.spring.khaddem.repositories.ContratRepository;
import tn.esprit.spring.khaddem.repositories.EquipeRepository;
import tn.esprit.spring.khaddem.repositories.EtudiantRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
 class EquipeServiceImplMock {
    @InjectMocks
    EquipeServiceImpl equipeService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void evoluerEquipes() {
        // Créez un mock :des faux repositories
        EquipeRepository equipeRepository = Mockito.mock(EquipeRepository.class);

        ContratRepository contratRepository = Mockito.mock(ContratRepository.class);

        Equipe firstEquipe = Equipe.builder()
                .nomEquipe("Tennis")
                .niveau(Niveau.SENIOR)
                .build();
        //renvoyer l'équipe que vous avez créée lorsque la méthode save est appelée.
        Mockito.when(equipeRepository.save(firstEquipe)).thenReturn(firstEquipe);
        Equipe equipeSaved = equipeRepository.save(firstEquipe);
        assertNotNull(equipeSaved);
        Mockito.verify(equipeRepository).save(firstEquipe);

        List<Equipe> equipess = new ArrayList<>();
        equipess.add(equipeSaved);


        // Créez un mock de EtudiantRepository

        EtudiantRepository etudiantRepository = Mockito.mock(EtudiantRepository.class);

        Etudiant etudiant = Etudiant.builder()
                .nomE("ahmed")
                .prenomE("ahmed")
                .equipes(equipess)
                .build();

        Etudiant etud = Etudiant.builder()
                .nomE("mariem")
                .prenomE("mariem")
                .equipes(equipess)
                .build();



        Mockito.when(etudiantRepository.save(etudiant)).thenReturn(etudiant);
        Mockito.when(etudiantRepository.save(etud)).thenReturn(etud);
        Etudiant etudiantSaved = etudiantRepository.save(etudiant);
        Etudiant etudsaved =etudiantRepository.save(etud);
        assertNotNull(etudiantSaved);
        assertNotNull(etud);
        Mockito.verify(etudiantRepository).save(etudiant);
        Mockito.verify(etudiantRepository).save(etud);

        //ajouter les deux etudiants sauvegardés à un liste
        List<Etudiant> etudiantsList = new ArrayList<>();
        etudiantsList.addAll(Stream.of(etudiant,etud).collect(Collectors.toList()));




        Date dateDeb= new Date();
        dateDeb.setYear(2015);

        Contrat contrat = Contrat.builder()
                .dateDebutContrat(dateDeb)
                .dateFinContrat(new Date())
                .archived(false)
                .etudiant(etudiant)
                .build();

        Mockito.when(contratRepository.save(contrat)).thenReturn(contrat);
        Contrat contratsaved =contratRepository.save(contrat);
        assertNotNull(contratsaved);

        Mockito.verify(contratRepository).save(contrat);

        List<Contrat> contratList = new ArrayList<>();
        contratList.addAll(Stream.of(contrat).collect(Collectors.toList()));



        // TO DO later
        //    when(equipeRepository.findById(firstEquipe.getIdEquipe())).thenReturn(Optional.of(firstEquipe));
        //   Equipe equipe=equipeServicee.retrieveEquipe(equipeSaved.getIdEquipe());
        //assertEquals(firstEquipe, equipe);
        //  verify(equipeRepository).findById(firstEquipe.getIdEquipe());

       /*  code 9dimm :  equipeServiceImp.evoluerEquipes();
        Equipe equipe=equipeServiceImp.retrieveEquipe(equipeSaved.getIdEquipe());
        assertEquals(equipe.getNiveau(), Niveau.EXPERT);

        Mockito.when(equipeServiceImp.retrieveEquipe(equipeSaved.getIdEquipe())).thenReturn(equipe);*/

    }
}
