package encheres.backoffice.service;

import encheres.backoffice.models.Enchere;
import encheres.backoffice.repository.EnchereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnchereService {
    @Autowired
    EnchereRepository encheresRepository;

    //getting all encheres record by using the method findaAll() of CrudRepository
    public List<Enchere> getAllEncheres()
    {
        List<Enchere> encheres = new ArrayList<Enchere>();
        encheresRepository.findAll().forEach(encheres::add);
        return encheres;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Enchere getEncheresById(int id)
    {
        return encheresRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Enchere enchere)
    {
        encheresRepository.save(enchere);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        encheresRepository.deleteById(id);
    }
    //updating a record
    public void update(Enchere enchere, int bookid)
    {
        encheresRepository.save(enchere);
    }
}
