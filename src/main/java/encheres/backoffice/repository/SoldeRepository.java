package encheres.backoffice.repository;

import encheres.backoffice.models.Solde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoldeRepository extends JpaRepository<Solde, Integer> {
    @Query(value = "select * from soldes where valid=0",nativeQuery = true)
    public List<Solde> getRechargementsAttente();
}
