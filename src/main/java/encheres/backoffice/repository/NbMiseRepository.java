package encheres.backoffice.repository;

import encheres.backoffice.models.statistiques.NbMise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NbMiseRepository extends CrudRepository<NbMise,Integer> {
}
