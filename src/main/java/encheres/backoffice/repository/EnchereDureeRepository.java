package encheres.backoffice.repository;
import encheres.backoffice.models.EnchereDuree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EnchereDureeRepository extends JpaRepository<EnchereDuree,Integer> {
    @Query(value = "select * from encheredurees order by idduree desc limit 1",nativeQuery = true)
    public List<EnchereDuree> getLastEnchereDuree();

    @Transactional
    @Modifying
    @Query(value = "insert into encheredurees values (default,:dureeMin,:dureeMax,NOW())",nativeQuery = true)
    public void addEnchereDuree(@Param("dureeMin") double dureeMin, @Param("dureeMax") double dureeMax);

}
