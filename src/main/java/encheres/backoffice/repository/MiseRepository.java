package encheres.backoffice.repository;
import encheres.backoffice.models.Mise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiseRepository extends CrudRepository<Mise,Integer> {
}
