package encheres.backoffice.repository;

import encheres.backoffice.models.statistiques.AvgMise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvgMiseRepository extends JpaRepository<AvgMise,Integer> {
}
