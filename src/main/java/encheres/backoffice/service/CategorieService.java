package encheres.backoffice.service;

import encheres.backoffice.models.Categorie;
import encheres.backoffice.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorieService {
    @Autowired
    CategorieRepository categorieRepository;

    //getting all categories record by using the method findaAll() of CrudRepository
    public List<Categorie> getAllCategories()
    {
        List<Categorie> categories = new ArrayList<Categorie>();
        categorieRepository.findAll().forEach(categories::add);
        return categories;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Categorie getCategoriesById(int id)
    {
        return categorieRepository.findById(id).get();
    }

    @Transactional
    public void saveOrUpdate(Categorie categorie)
    {
        categorieRepository.save(categorie);
    }

    public void delete(int id)
    {
        categorieRepository.deleteById(id);
    }
    //updating a record
    public void update(Categorie categorie, int bookid)
    {
        categorieRepository.save(categorie);
    }
}
