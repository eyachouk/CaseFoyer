package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entitiy.Reservation;

import java.lang.ScopedValue;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByIdReservation(String idReservation);
}
