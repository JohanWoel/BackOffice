package encheres.backoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class RedirectController {
    @GetMapping
    public RedirectView toLogin(HttpSession session){
        return new RedirectView("admins/loginForm");
    }

    @GetMapping("must_logged")
    public RedirectView mustLogin(HttpSession session){
        return new RedirectView("admins/loginFormMust");
    }
}
