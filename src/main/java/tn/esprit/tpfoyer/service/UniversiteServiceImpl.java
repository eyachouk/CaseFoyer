package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entitiy.Foyer;
import tn.esprit.tpfoyer.entitiy.Universite;
import tn.esprit.tpfoyer.repository.IFoyerRepository;
import tn.esprit.tpfoyer.repository.IUniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService{
    IUniversiteRepository universiteRepository;
    IFoyerRepository foyerRepository;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé"));
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        universite.setFoyers(foyer);
        foyer.setUniversite(universite);

        universiteRepository.save(universite);
        foyerRepository.save(foyer);

        return universite;
    }
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université non trouvée"));

        Foyer foyer = universite.getFoyers();
        if (foyer != null) {
            foyer.setUniversite(null);
            universite.setFoyers(null);

            foyerRepository.save(foyer);
            universiteRepository.save(universite);
        }

        return universite;}
}
