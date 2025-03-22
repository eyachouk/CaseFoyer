package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entitiy.Bloc;

import java.util.List;

public interface IBlocService {
    public List<Bloc> retrieveBlocs();
    public Bloc updateBloc (Bloc bloc);
    public Bloc addBloc (Bloc bloc);
    public Bloc retrieveBloc (long idBloc);
    public void removeBloc (long idBloc);
     Bloc affecterChambresABloc(List<Long> numChambre, long idBloc);

    }
