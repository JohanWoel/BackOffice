package encheres.backoffice.repository;

import encheres.backoffice.models.statistiques.NbEncheres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NbEncheresRepository extends JpaRepository<NbEncheres,Integer> {
}
