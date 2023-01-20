package encheres.backoffice.controller;

import encheres.backoffice.format.Data;
import encheres.backoffice.models.AdminToken;
import encheres.backoffice.models.Categorie;
import encheres.backoffice.service.AdminService;
import encheres.backoffice.service.AdminTokenService;
import encheres.backoffice.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/categories")
@CrossOrigin
public class CategorieController {
    @Autowired
    CategorieService categorieService;
    @Autowired
    AdminTokenService adminTokenService;

    //creating a get mapping that retrieves all the Categorie detail from the database
    @GetMapping()
    private String getAllCategories(Model model) {
        model.addAttribute("categories", new Data(categorieService.getAllCategories()));
        model.addAttribute("page", "categories_list");
        return "index";
    }

    @GetMapping("/{categorieid}")
    private Object getCategories(@PathVariable("categorieid") int categorieid, Model model, HttpSession session) {
        AdminToken token = (AdminToken) session.getAttribute("token");
        if (token == null) {
            return new RedirectView("/must_logged");
        }
        if (!adminTokenService.isTokenValid(token.getToken())) {
            return new RedirectView("/must_logged");
        }
        model.addAttribute("categorie", categorieService.getCategoriesById(categorieid));
        model.addAttribute("page", "categorie_update");
        return "index";
    }

    @DeleteMapping("/{categorieid}")
    private void delete(@PathVariable("categorieid") int categorieid) {
        categorieService.delete(categorieid);
    }

    @PostMapping
    private String save(@RequestParam("idCategorie") int idcategorie,@RequestParam("libelle") String libelle, Model model) {
        Categorie categorie=new Categorie();
        categorie.setIdCategorie(idcategorie);
        categorie.setLibelle(libelle);
        categorieService.saveOrUpdate(categorie);
        return getAllCategories(model);
    }
    //creating put mapping that updates the categorie detail
//    @PostMapping("/update")
//    private Categorie update(@RequestBody Categorie categorie)
//    {
//        categorieService.saveOrUpdate(categorie);
//        return categorie;
//    }

    @PostMapping("/new")
    private String save(@RequestParam(name = "libelle") String libelle, Model model) {
        Categorie categorie = new Categorie();
        categorie.setLibelle(libelle);
        categorieService.saveOrUpdate(categorie);
        return getAllCategories(model);
    }
//    creating put mapping that updates the categorie detail

//    @PutMapping("/{categorieid}/libelle/{nomcategorie}")
//    private void update(@PathVariable("nomcategorie") String libelle, @PathVariable("categorieid") int id, Model model)
//    {
//        Categorie categorie = new Categorie();
//        categorie.setLibelle(libelle);
//        categorie.setIdCategorie(id);
//        categorieService.saveOrUpdate(categorie);
//    }

    /*@PutMapping
    private String update(@RequestBody Categorie categorie, Model model)
    {
        categorieService.saveOrUpdate(categorie);
        return getAllCategories(model);
    }*/

    @GetMapping("/toForm")
    private Object toForm(Model model,HttpSession session) {
        AdminToken token = (AdminToken) session.getAttribute("token");
        if (token == null) {
            return new RedirectView("/must_logged");
        }
        if (!adminTokenService.isTokenValid(token.getToken())) {
            return new RedirectView("/must_logged");
        }
        model.addAttribute("page", "categorie_add");
        return "index";
    }

}
