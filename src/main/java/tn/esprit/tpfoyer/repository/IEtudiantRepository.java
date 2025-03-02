package tn.esprit.tpfoyer.repository;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entitiy.Etudiant;
@Repository
public interface IEtudiantRepository extends JpaRepository<Etudiant, Long> {
}
