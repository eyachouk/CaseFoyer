package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entitiy.Foyer;
@Repository
public interface IFoyerRepository extends JpaRepository<Foyer,Long> {

}
