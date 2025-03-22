package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entitiy.Bloc;
import tn.esprit.tpfoyer.entitiy.Foyer;
import tn.esprit.tpfoyer.entitiy.Universite;
import tn.esprit.tpfoyer.repository.IBlocRepository;
import tn.esprit.tpfoyer.repository.IFoyerRepository;
import tn.esprit.tpfoyer.repository.IUniversiteRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    IFoyerRepository foyerRepository;
    IBlocRepository blocRepository;
    IUniversiteRepository universiteRepository;


    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université non trouvée"));

        foyer.setUniversite(universite);
        universite.setFoyers(foyer);

        List<Bloc> blocs = foyer.getBlocs();
        if (blocs != null) {
            blocs.forEach(bloc -> bloc.setFoyer(foyer));
            blocRepository.saveAll(blocs);
        }

        foyerRepository.save(foyer);
        universiteRepository.save(universite);

        return foyer;
    }
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
