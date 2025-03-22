package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entitiy.Bloc;
import tn.esprit.tpfoyer.entitiy.Chambre;
import tn.esprit.tpfoyer.repository.IBlocRepository;
import tn.esprit.tpfoyer.repository.IChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService{
    IBlocRepository blocRepository;
    IChambreRepository chambreRepository;

    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc non trouvé"));

        List<Chambre> chambres = chambreRepository.findAllById(numChambre);
        chambres.forEach(chambre -> chambre.setBloc(bloc));

        chambreRepository.saveAll(chambres);
        bloc.setChambres(chambres);

        return blocRepository.save(bloc);
    }
    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
    blocRepository.deleteById(idBloc);
    }
}
