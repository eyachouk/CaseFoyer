package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entitiy.Bloc;
import tn.esprit.tpfoyer.entitiy.Chambre;
import tn.esprit.tpfoyer.entitiy.TypeChambre;

import java.util.List;

@Repository
public interface IChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByUniversiteNomAndTypeChambreAndReservationsIsEmpty(String nomUniversite, TypeChambre type);
    //@Query("SELECT c FROM Chambre c WHERE c.bloc.id = :idBloc AND c.typeChambre = :typeC")
    //List<Chambre> findByBlocIdAndTypeChambre(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);
    //avec keywords
    List<Chambre> findByBlocIdAndTypeChambre(long idBloc, TypeChambre typeC);

    List<Chambre> findByBloc(Bloc bloc);
}
