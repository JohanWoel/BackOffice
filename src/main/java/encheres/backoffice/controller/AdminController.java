package encheres.backoffice.controller;

import encheres.backoffice.format.Data;
import encheres.backoffice.models.Admin;
import encheres.backoffice.models.AdminToken;
import encheres.backoffice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    AdminService adminService;
    //creating a get mapping that retrieves all the Admin detail from the database
    @GetMapping()
    private Object getAllAdmins()
    {
        try {
            return new Data(adminService.getAllAdmins());
        }catch (Exception e){
            return new Error(e);
        }
    }
    //creating a get mapping that retrieves the detail of a specific admins
    @GetMapping("/{adminid}")
    private Admin getAdmins(@PathVariable("adminid") int adminid)
    {
        return adminService.getAdminsById(adminid);
    }
    //creating a delete mapping that deletes a specified admins
    @DeleteMapping("/{adminid}")
    private void delete(@PathVariable("adminid") int adminid)
    {
        adminService.delete(adminid);
    }
    //creating post mapping that post the admin detail in the database
    @PostMapping()
    private int save(@RequestBody Admin admin)
    {
        adminService.saveOrUpdate(admin);
        return admin.getIdAdmin();
    }
    //creating put mapping that updates the admin detail
    @PutMapping()
    private Admin update(@RequestBody Admin admin)
    {
        adminService.saveOrUpdate(admin);
        return admin;
    }

    @PostMapping("/login")
    private String loginAdmin(@RequestParam(name = "identifiant") String identifiant, @RequestParam(name = "mdp") String password, Model model, HttpSession session) throws Exception {
        Admin admin = new Admin();
        if (identifiant.isEmpty() || password.isEmpty()) {
            admin.setIdentifiant(null);
            admin.setPassword(null);
            Data data = adminService.login(admin);
            model.addAttribute("error", data);
            return "admin_login";
        } else {
            admin.setIdentifiant(identifiant);
            admin.setPassword(password);
            Data data = adminService.login(admin);
            if (data.getData() instanceof Exception) {
                model.addAttribute("error", data);
                return "admin_login";
            } else {
                model.addAttribute("data", data);
                model.addAttribute("page", "adminConnected_TransitionPage");
                if (data.getData() instanceof AdminToken){
                    session.setAttribute("token",(AdminToken)data.getData());
                }
                session.setAttribute("token",data.getData());
                return "index";
            }
        }
    }

    @GetMapping("/accueil")
    private String toAccueil(Model model) {
        model.addAttribute("page", "accueil");
        return "index";
    }

    @GetMapping("/loginForm")
    private String getLoginForm(){
        return "admin_login";
    }

    @GetMapping("/loginFormMust")
    private String getLoginFormMust(Model model){
        model.addAttribute("must_logged","Veuillez vous connecter pour accéder à cette page");
        return "admin_login";
    }
}
