package encheres.backoffice.service;

import encheres.backoffice.models.Mise;
import encheres.backoffice.repository.MiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MiseService {
    @Autowired
    MiseRepository miseRepository;

    //getting all mises record by using the method findaAll() of CrudRepository
    public List<Mise> getAllMises()
    {
        List<Mise> mises = new ArrayList<Mise>();
        miseRepository.findAll().forEach(mises::add);
        return mises;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Mise getMisesById(int id)
    {
        return miseRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Mise mise)
    {
        miseRepository.save(mise);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        miseRepository.deleteById(id);
    }
    //updating a record
    public void update(Mise mise, int bookid)
    {
        miseRepository.save(mise);
    }
}
