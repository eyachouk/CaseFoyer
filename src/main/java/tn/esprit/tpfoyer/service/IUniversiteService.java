package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entitiy.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (long idUniversite);
    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);
     Universite desaffecterFoyerAUniversite(long idUniversite);


    }
