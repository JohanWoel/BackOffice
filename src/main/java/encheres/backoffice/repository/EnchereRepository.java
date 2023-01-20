package encheres.backoffice.repository;
import encheres.backoffice.models.Enchere;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnchereRepository extends CrudRepository<Enchere,Integer> {
}
