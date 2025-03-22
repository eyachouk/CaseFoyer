package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entitiy.*;
import tn.esprit.tpfoyer.repository.IBlocRepository;
import tn.esprit.tpfoyer.repository.IChambreRepository;
import tn.esprit.tpfoyer.repository.IEtudiantRepository;
import tn.esprit.tpfoyer.repository.IReservationRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    IReservationRepository reservationRepository;
    IChambreRepository chambreRepository;


    IEtudiantRepository etudiantRepository;
    IBlocRepository blocRepository;

    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc non trouvé"));

        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        List<Chambre> chambres = chambreRepository.findByBloc(bloc);
        Chambre chambreDisponible = chambres.stream()
                .filter(chambre -> chambre.getReservations().size() < getCapaciteMax(chambre.getTypeC()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucune chambre disponible"));

        Reservation reservation = new Reservation();
        reservation.setIdReservation(generateReservationId(chambreDisponible));
        reservation.setAnneeUniversitaire(new Date());
        reservation.setEstValide(true);
        reservation.setChambre(chambreDisponible);
        reservation.setEtudiant(etudiant);

        return reservationRepository.save(reservation);
    }

    private String generateReservationId(Chambre chambre) {
        return chambre.getNumeroChambre() + "-" + chambre.getBloc().getNomBloc() + "-" + new SimpleDateFormat("yyyy").format(new Date());
    }

    private int getCapaciteMax(TypeChambre typeC) {
        switch (typeC) {
            case SIMPLE:
                return 1;
            case DOUBLE:
                return 2;
            case TRIPLE:
                return 3;
            default:
                throw new IllegalArgumentException("Type de chambre non supporté");
        }
    }

    public Reservation ajouterReservationEtAffecterAChambreEtEtudiant(Reservation reservation, long idChambre, long idEtudiant) {
        Chambre chambre = chambreRepository.findById(idChambre)
                .orElseThrow(() -> new RuntimeException("Chambre non trouvée"));
        Etudiant etudiant = etudiantRepository.findById(idEtudiant)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));

        reservation.setChambre(chambre);
        reservation.setEtudiant(etudiant);

        return reservationRepository.save(reservation);
    }
    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findByIdReservation(idReservation);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        return reservationRepository.findByAnneeUniversitaireAndChambreUniversiteNom(anneeUniversite, nomUniversite);
    }
}
