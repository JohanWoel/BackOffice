package encheres.backoffice.repository;

import encheres.backoffice.models.statistiques.AvgMise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvgMiseRepository extends CrudRepository<AvgMise,Integer> {
}
