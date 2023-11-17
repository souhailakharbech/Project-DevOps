package tn.esprit.spring.khaddem.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.khaddem.entities.DetailEquipe;
import tn.esprit.spring.khaddem.repositories.DetailEquipeRepository;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class DetailsEquipeServiceImp {
    @Autowired
   DetailEquipeRepository detailEquipeRepository;
    @Transactional
    public DetailEquipe addDetailsEquipe(DetailEquipe detailEquipee) {
        return  detailEquipeRepository.save(detailEquipee);
    }

}
