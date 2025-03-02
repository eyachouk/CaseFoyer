package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entitiy.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (String idReservation);
}
