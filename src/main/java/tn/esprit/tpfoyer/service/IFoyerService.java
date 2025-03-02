package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entitiy.Foyer;

import java.util.List;


public interface IFoyerService {
    public Foyer findFoyer(Long id);
    public List<Foyer> findAllFoyers();
    public Foyer saveFoyer(Foyer foyer);
    public Foyer updateFoyer(Foyer foyer);
    public void deleteFoyer(Foyer foyer);

}
