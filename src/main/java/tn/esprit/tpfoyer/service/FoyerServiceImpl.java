package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entitiy.Foyer;
import tn.esprit.tpfoyer.repository.IFoyerRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    IFoyerRepository foyerRepository;
    @Override
    public Foyer findFoyer(Long id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Foyer> findAllFoyers() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer saveFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
          return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(Foyer foyer) {
        foyerRepository.delete(foyer);
    }
}
