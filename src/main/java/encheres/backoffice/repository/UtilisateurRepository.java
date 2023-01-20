package encheres.backoffice.repository;
import encheres.backoffice.models.Utilisateur;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur,Integer> {
    @Query(value = "update Utilisateurs set montantsolde=montantsolde+(?1) where idutilisateur=?2",nativeQuery = true)
    @Modifying
    public int addMontantToActuel(int montant,int idUtilisateur);
}
