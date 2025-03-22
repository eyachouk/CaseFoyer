package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entitiy.Reservation;

import java.util.Date;
import java.util.List;


@Repository
public interface IReservationRepository extends JpaRepository<Reservation, String> {
    Reservation findByIdReservation(String idReservation);
    List<Reservation> findByAnneeUniversitaireAndChambreUniversiteNom(Date anneeUniversitaire, String nomUniversite);

}
