package encheres.backoffice.repository;
import encheres.backoffice.models.Commission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionRepository extends CrudRepository<Commission,Integer> {
}
