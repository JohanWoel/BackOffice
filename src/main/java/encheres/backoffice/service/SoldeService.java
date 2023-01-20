package encheres.backoffice.service;

import encheres.backoffice.models.Solde;
import encheres.backoffice.repository.SoldeRepository;
import encheres.backoffice.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class SoldeService {
    @Autowired
    SoldeRepository soldeRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    //getting all soldes record by using the method findaAll() of CrudRepository
    public List<Solde> getAllSoldes()
    {
        List<Solde> soldes = new ArrayList<Solde>();
        soldeRepository.findAll().forEach(soldes::add);
        return soldes;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Solde getSoldesById(int id)
    {
        return soldeRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Solde solde)
    {
        soldeRepository.save(solde);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        soldeRepository.deleteById(id);
    }
    //updating a record
    public void update(Solde solde, int bookid)
    {
        soldeRepository.save(solde);
    }

    @Transactional
    public void valider(Solde solde){
        solde.setValid(1);
        soldeRepository.save(solde);
        utilisateurRepository.addMontantToActuel(solde.getMontant(),solde.getUtilisateur().getIdUtilisateur());
    }

    @Transactional
    public void refuser(Solde solde){
        solde.setValid(-1);
        soldeRepository.save(solde).getIdSolde();
    }

    public List<Solde> getSoldeAnttente(){
        return soldeRepository.getRechargementsAttente();
    }

}
