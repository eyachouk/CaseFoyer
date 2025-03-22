package tn.esprit.tpfoyer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.entitiy.Reservation;
import tn.esprit.tpfoyer.service.ReservationServiceImpl;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    ReservationServiceImpl reservationService;

    @PostMapping("/ajouter")
    public ResponseEntity<Reservation> ajouterReservation(@RequestParam long idBloc, @RequestParam long cinEtudiant) {
        Reservation reservation = reservationService.ajouterReservation(idBloc, cinEtudiant);
        return ResponseEntity.ok(reservation);
    }
}
