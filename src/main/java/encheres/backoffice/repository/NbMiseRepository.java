package encheres.backoffice.repository;

import encheres.backoffice.models.statistiques.NbMise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NbMiseRepository extends JpaRepository<NbMise,Integer> {
}
