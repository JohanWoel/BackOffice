package encheres.backoffice.service;

import encheres.backoffice.models.Utilisateur;
import encheres.backoffice.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    //getting all utilisateurs record by using the method findaAll() of CrudRepository
    public List<Utilisateur> getAllUtilisateurs()
    {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        utilisateurRepository.findAll().forEach(utilisateurs::add);
        return utilisateurs;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Utilisateur getUtilisateursById(int id)
    {
        return utilisateurRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Utilisateur utilisateur)
    {
        utilisateurRepository.save(utilisateur);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        utilisateurRepository.deleteById(id);
    }
    //updating a record
    public void update(Utilisateur utilisateur, int bookid)
    {
        utilisateurRepository.save(utilisateur);
    }
}
