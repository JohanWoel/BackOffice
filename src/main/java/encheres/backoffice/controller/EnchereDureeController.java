package encheres.backoffice.controller;

import encheres.backoffice.exception.IntervalleException;
import encheres.backoffice.format.Data;
import encheres.backoffice.models.EnchereDuree;
import encheres.backoffice.service.EnchereDureeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/durees")
public class EnchereDureeController {
    @Autowired
    EnchereDureeService enchereDureeService;
    //creating a get mapping that retrieves all the EnchereDuree detail from the database
    @GetMapping()
    private Object getAllEnchereDurees()
    {
        try {
            return new Data(enchereDureeService.getAllEnchereDurees());
        }catch (Exception e){
            return new Error(e);
        }
    }
    //creating a get mapping that retrieves the detail of a specific enchereDurees
    @GetMapping("/{enchereDureeid}")
    private EnchereDuree getEnchereDurees(@PathVariable("enchereDureeid") int enchereDureeid)
    {
        return enchereDureeService.getEnchereDureesById(enchereDureeid);
    }
    //creating a delete mapping that deletes a specified enchereDurees
    @DeleteMapping("/{enchereDureeid}")
    private void delete(@PathVariable("enchereDureeid") int enchereDureeid)
    {
        enchereDureeService.delete(enchereDureeid);
    }
    //creating post mapping that post the enchereDuree detail in the database
    @PostMapping()
    private int save(@RequestBody EnchereDuree enchereDuree)
    {
        enchereDureeService.save(enchereDuree);
        return enchereDuree.getIdDuree();
    }
    //creating put mapping that updates the enchereDuree detail
    @PutMapping()
    private EnchereDuree update(@RequestBody EnchereDuree enchereDuree)
    {
        enchereDureeService.save(enchereDuree);
        return enchereDuree;
    }

    // http://localhost:1234/durees/insertion
    @GetMapping("/insertion")
    private String getEnchereDuree(Model model){
        model.addAttribute("durees",enchereDureeService.getLastEnchereDuree());
        model.addAttribute("page","dureeEncheres");
        return "index";
    }

    @PostMapping("/inserer")
    private String addEnchereDuree(@RequestParam(name = "dureeMin") String dureeMin, @RequestParam(name = "dureeMax") String dureeMax, Model model){
        double min = Double.valueOf(dureeMin);
        double max = Double.valueOf(dureeMax);
        EnchereDuree ed = new EnchereDuree();
        model.addAttribute("durees",enchereDureeService.getLastEnchereDuree());
        model.addAttribute("page","dureeEncheres");
        try {
            // success
            ed.setDureeMinDureeMax(min, max);
            enchereDureeService.addEnchereDuree(ed);
            model.addAttribute("indication","Configuration reussie");
            return "index";
        }
        catch (Exception e){
            // error
            model.addAttribute("indication",e.getMessage());
            return "index";
        }

    }

}
