package encheres.backoffice.repository;
import encheres.backoffice.models.Mise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiseRepository extends JpaRepository<Mise,Integer> {
}
