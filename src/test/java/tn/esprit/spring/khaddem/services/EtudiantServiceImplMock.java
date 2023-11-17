package tn.esprit.spring.khaddem.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.khaddem.entities.Contrat;
import tn.esprit.spring.khaddem.entities.Equipe;
import tn.esprit.spring.khaddem.entities.Etudiant;
import tn.esprit.spring.khaddem.repositories.ContratRepository;
import tn.esprit.spring.khaddem.repositories.EquipeRepository;
import tn.esprit.spring.khaddem.repositories.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@Transactional
class EtudiantServiceImplMock {
    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Mock
    private ContratRepository contratRepository;

    @Mock
    private EquipeRepository equipeRepository;

    @Mock
    private EtudiantRepository etudiantRepository;



    @Test
    void testAddAndAssignEtudiantToEquipeAndContract() {
        // Créer des objets factices pour le test
        Contrat contrat = new Contrat();
        Equipe equipe = new Equipe();
        Etudiant etudiant = new Etudiant();

        // Configurer le comportement des mocks
        Mockito.when(contratRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(contrat));
        Mockito.when(equipeRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(equipe));
        Mockito.when(etudiantRepository.save(Mockito.any(Etudiant.class))).thenReturn(etudiant);

        // Appeler la méthode à tester
        Etudiant result = etudiantService.addAndAssignEtudiantToEquipeAndContract(etudiant, 1, 2);

        // Vérifier les interactions avec les mocks
        Mockito.verify(contratRepository).findById(1);
        Mockito.verify(equipeRepository).findById(2);
        Mockito.verify(etudiantRepository).save(etudiant);

        // Vérifier que l'étudiant est maintenant assigné au contrat et à l'équipe
        assertNotNull(result);
        assertSame(etudiant, result);

       // Vérifier que les interactions avec la base de données n'ont pas eu lieu
        Mockito.verifyNoMoreInteractions(contratRepository);
        Mockito.verifyNoMoreInteractions(equipeRepository);
        Mockito.verifyNoMoreInteractions(etudiantRepository);
    }


}