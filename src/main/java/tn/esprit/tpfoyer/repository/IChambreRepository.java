package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entitiy.Chambre;
@Repository
public interface IChambreRepository extends JpaRepository<Chambre, Long> {
}
