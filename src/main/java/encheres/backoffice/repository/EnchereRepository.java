package encheres.backoffice.repository;
import encheres.backoffice.models.Enchere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnchereRepository extends JpaRepository<Enchere,Integer> {
}
