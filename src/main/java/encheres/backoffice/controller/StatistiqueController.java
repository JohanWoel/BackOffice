package encheres.backoffice.controller;

import encheres.backoffice.service.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Controller
@RequestMapping("/statistiques")
public class StatistiqueController {
    @Autowired
    StatistiqueService statistiqueService;

    @GetMapping("/all")
    private HashMap<String, Iterable<?>> getStatistiques(){
        return statistiqueService.getStatistiques();
    }

    @GetMapping
    private String goToPage(Model model){
        return "index";
    }

    @GetMapping("/nbmises")
    private String getNbMises(Model model){
        model.addAttribute("stat",statistiqueService.getStatNbMises());
        model.addAttribute("page","statistiques/nbmise");
        return "index";
    }
    @GetMapping("/nbencheres")
    private String getNbEncheres(Model model){
        model.addAttribute("stat",statistiqueService.getStatNbEncheres());
        model.addAttribute("page","statistiques/nbencheres");
        return "index";
    }

    @GetMapping("/avgmises")
    private String getAvgMises(Model model){
        model.addAttribute("stat",statistiqueService.getStatAvgMises());
        model.addAttribute("page","statistiques/avgmises");
        return "index";
    }
}
