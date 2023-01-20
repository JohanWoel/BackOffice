package encheres.backoffice.repository;

import encheres.backoffice.models.statistiques.NbEncheres;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NbEncheresRepository extends CrudRepository<NbEncheres,Integer> {
}
