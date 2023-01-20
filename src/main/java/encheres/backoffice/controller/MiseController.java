package encheres.backoffice.controller;

import encheres.backoffice.format.Data;
import encheres.backoffice.models.Mise;
import encheres.backoffice.service.MiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mises")
public class MiseController {
    @Autowired
    MiseService miseService;
    //creating a get mapping that retrieves all the Mise detail from the database
    @GetMapping()
    private Object getAllMises()
    {
        try {
            return new Data(miseService.getAllMises());
        }catch (Exception e){
            return new Error(e);
        }
    }
    //creating a get mapping that retrieves the detail of a specific mises
    @GetMapping("/{miseid}")
    private Mise getMises(@PathVariable("miseid") int miseid)
    {
        return miseService.getMisesById(miseid);
    }
    //creating a delete mapping that deletes a specified mises
    @DeleteMapping("/{miseid}")
    private void delete(@PathVariable("miseid") int miseid)
    {
        miseService.delete(miseid);
    }
    //creating post mapping that post the mise detail in the database
    @PostMapping()
    private int save(@RequestBody Mise mise)
    {
        miseService.saveOrUpdate(mise);
        return mise.getIdMise();
    }
    //creating put mapping that updates the mise detail
    @PutMapping()
    private Mise update(@RequestBody Mise mise)
    {
        miseService.saveOrUpdate(mise);
        return mise;
    }

}
