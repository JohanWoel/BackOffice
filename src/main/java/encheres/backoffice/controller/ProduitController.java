package encheres.backoffice.controller;

import encheres.backoffice.format.Data;
import encheres.backoffice.models.AdminToken;
import encheres.backoffice.models.Categorie;
import encheres.backoffice.models.Produit;
import encheres.backoffice.service.AdminTokenService;
import encheres.backoffice.service.CategorieService;
import encheres.backoffice.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/produits")
public class ProduitController {
    @Autowired
    ProduitService produitService;
    @Autowired
    AdminTokenService adminTokenService;
    @Autowired
    CategorieService categorieService;

    //creating a get mapping that retrieves all the Produit detail from the database
    @GetMapping
    private String getAllProduits(Model model) {
        model.addAttribute("page", "produits/listProduits");
        model.addAttribute("produits", produitService.getAllProduits());
        return "index";
    }

    @GetMapping("/insert")
    private Object toForm(Model model, HttpSession session) {

        AdminToken token = (AdminToken) session.getAttribute("token");
        if (token == null) {
            return new RedirectView("/must_logged");
        }
        if (!adminTokenService.isTokenValid(token.getToken())) {
            return new RedirectView("/must_logged");
        }
        model.addAttribute("page", "produits/insertionProduit");
        model.addAttribute("categories", categorieService.getAllCategories());
        model.addAttribute("produits", produitService.getAllProduits());
        return "index";
    }

    //creating a get mapping that retrieves the detail of a specific produits
    @GetMapping("/{produitid}")
    private Produit getProduits(@PathVariable("produitid") int produitid) {
        return produitService.getProduitsById(produitid);
    }

    //creating a delete mapping that deletes a specified produits
    @DeleteMapping("/{produitid}")
    private void delete(@PathVariable("produitid") int produitid) {
        produitService.delete(produitid);
    }
    //creating post mapping that post the produit detail in the database

    @PostMapping
    private String save(@RequestParam(name = "nomProduit") String nomProduit, @RequestParam(name = "idCategorie") int idCategorie,Model model) {
        Produit p = new Produit();
        Categorie c = new Categorie();
        c.setIdCategorie(idCategorie);
        p.setNomProduit(nomProduit);
        p.setCategorie(c);
        produitService.saveOrUpdate(p);
        // redirection apres insertion
        return getAllProduits(model);
    }

    //creating put mapping that updates the produit detail
    @PutMapping()
    private Produit update(@RequestBody Produit produit) {
        produitService.saveOrUpdate(produit);
        return produit;
    }

}
