package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entitiy.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (String idReservation);
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite);
    public Reservation ajouterReservationEtAffecterAChambreEtEtudiant(Reservation reservation, long idChambre, long idEtudiant);

}

