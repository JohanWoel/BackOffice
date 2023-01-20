package encheres.backoffice.controller;

import encheres.backoffice.format.Data;
import encheres.backoffice.models.Admin;
import encheres.backoffice.models.AdminToken;
import encheres.backoffice.models.Solde;
import encheres.backoffice.service.AdminTokenService;
import encheres.backoffice.service.SoldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/soldes")
public class SoldeController {
    @Autowired
    SoldeService soldeService;
    @Autowired
    AdminTokenService adminTokenService;
    //creating a get mapping that retrieves all the Solde detail from the database
    @GetMapping()
    private Object getAllSoldes()
    {
        try {
            return new Data(soldeService.getAllSoldes());
        }catch (Exception e){
            return new Error(e);
        }
    }
    //creating a get mapping that retrieves the detail of a specific soldes
    @GetMapping("/{soldeid}")
    private Solde getSoldes(@PathVariable("soldeid") int soldeid)
    {
        return soldeService.getSoldesById(soldeid);
    }
    //creating a delete mapping that deletes a specified soldes
    @DeleteMapping("/{soldeid}")
    private void delete(@PathVariable("soldeid") int soldeid)
    {
        soldeService.delete(soldeid);
    }
    //creating post mapping that post the solde detail in the database
    @PostMapping()
    private int save(@RequestBody Solde solde)
    {
        soldeService.saveOrUpdate(solde);
        return solde.getIdSolde();
    }
    //creating put mapping that updates the solde detail
    @PutMapping()
    private Solde update(@RequestBody Solde solde)
    {
        soldeService.saveOrUpdate(solde);
        return solde;
    }

    @GetMapping("/attentes")
    private Object getDepotAttente(Model model,HttpSession session){
        AdminToken token=(AdminToken) session.getAttribute("token");
        if (token==null){
            return new RedirectView("/must_logged");
        }
        if (!adminTokenService.isTokenValid(token.getToken())){
            return new RedirectView("/must_logged");
        }
        model.addAttribute("attentes",soldeService.getSoldeAnttente());
        model.addAttribute("page","attente");
        return "index";
    }

    @PutMapping("/{soldeid}/validate")
    private RedirectView validateDepot(@PathVariable("soldeid") int idSolde){
        Solde solde=soldeService.getSoldesById(idSolde);
        soldeService.valider(solde);
        return new RedirectView("soldes/attentes");
    }

    @PutMapping("/{soldeid}/refuse")
    private RedirectView refuseDepot(@PathVariable("soldeid") int idSolde){
        Solde solde=soldeService.getSoldesById(idSolde);
        soldeService.refuser(solde);
        return new RedirectView("soldes/attentes");
    }

}
