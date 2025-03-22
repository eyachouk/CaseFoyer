package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entitiy.Chambre;
import tn.esprit.tpfoyer.entitiy.TypeChambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre (Chambre c);
    Chambre retrieveChambre (long idChambre);
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);

}
