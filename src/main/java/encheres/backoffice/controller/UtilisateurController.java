package encheres.backoffice.controller;

import encheres.backoffice.format.Data;
import encheres.backoffice.models.Utilisateur;
import encheres.backoffice.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    UtilisateurService utilisateurService;
    //creating a get mapping that retrieves all the Utilisateur detail from the database
    @GetMapping()
    private Object getAllUtilisateurs()
    {
        try {
            return new Data(utilisateurService.getAllUtilisateurs());
        }catch (Exception e){
            return new Error(e);
        }
    }
    //creating a get mapping that retrieves the detail of a specific utilisateur
    @GetMapping("/{utilisateurid}")
    private Utilisateur getUtilisateurs(@PathVariable("utilisateurid") int utilisateurid)
    {
        return utilisateurService.getUtilisateursById(utilisateurid);
    }
    //creating a delete mapping that deletes a specified utilisateur
    @DeleteMapping("/{utilisateurid}")
    private void delete(@PathVariable("utilisateurid") int utilisateurid)
    {
        utilisateurService.delete(utilisateurid);
    }
    //creating post mapping that post the utilisateur detail in the database
    @PostMapping()
    private int save(@RequestBody Utilisateur utilisateur)
    {
        utilisateurService.saveOrUpdate(utilisateur);
        return utilisateur.getIdUtilisateur();
    }
    //creating put mapping that updates the utilisateur detail
    @PutMapping()
    private Utilisateur update(@RequestBody Utilisateur utilisateur)
    {
        utilisateurService.saveOrUpdate(utilisateur);
        return utilisateur;
    }

}
