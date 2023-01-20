package encheres.backoffice.controller;

import encheres.backoffice.format.Data;
import encheres.backoffice.models.Enchere;
import encheres.backoffice.service.EnchereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/encheres")
public class EnchereController {
    @Autowired
    EnchereService enchereService;
    //creating a get mapping that retrieves all the Enchere detail from the database
    @GetMapping()
    private Object getAllEncheres()
    {
        try {
            return new Data(enchereService.getAllEncheres());
        }catch (Exception e){
            return new Error(e);
        }
    }
    //creating a get mapping that retrieves the detail of a specific encheres
    @GetMapping("/{enchereid}")
    private Enchere getEncheres(@PathVariable("enchereid") int enchereid)
    {
        return enchereService.getEncheresById(enchereid);
    }
    //creating a delete mapping that deletes a specified encheres
    @DeleteMapping("/{enchereid}")
    private void delete(@PathVariable("enchereid") int enchereid)
    {
        enchereService.delete(enchereid);
    }
    //creating post mapping that post the enchere detail in the database
    @PostMapping()
    private int save(@RequestBody Enchere enchere)
    {
        enchereService.saveOrUpdate(enchere);
        return enchere.getIdEnchere();
    }
    //creating put mapping that updates the enchere detail
    @PutMapping()
    private Enchere update(@RequestBody Enchere enchere)
    {
        enchereService.saveOrUpdate(enchere);
        return enchere;
    }

}
