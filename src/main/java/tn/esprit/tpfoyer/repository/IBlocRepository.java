package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entitiy.Bloc;
@Repository
public interface IBlocRepository extends JpaRepository<Bloc, Long> {
}
