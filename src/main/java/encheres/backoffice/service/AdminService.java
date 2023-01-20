package encheres.backoffice.service;

import encheres.backoffice.format.Data;
import encheres.backoffice.models.Admin;
//import encheres.backoffice.models.AdminToken;
import encheres.backoffice.models.AdminToken;
import encheres.backoffice.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AdminTokenService adminTokenService;

    //getting all admins record by using the method findaAll() of CrudRepository
    public List<Admin> getAllAdmins()
    {
        List<Admin> admins = new ArrayList<Admin>();
        adminRepository.findAll().forEach(admins::add);
        return admins;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Admin getAdminsById(int id)
    {
        return adminRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Admin admin)
    {
        adminRepository.save(admin);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        adminRepository.deleteById(id);
    }
    //updating a record
    public void update(Admin admin, int bookid)
    {
        adminRepository.save(admin);
    }

    public Data login(Admin admin) throws Exception{
        if (admin.getIdentifiant() == null || admin.getPassword() == null)
            return new Data(new Exception("Veuillez remplir tout les champs"));
        else {
            Admin adm = adminRepository.findByIdentifiantAndPassword(admin.getIdentifiant(), DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
            if (adm != null) {
                AdminToken token = new AdminToken();
                token.setToken(AdminTokenService.generateToken(String.valueOf(adm.getIdAdmin())));
                token.setAdmin(adm);
                token.setDateGeneration(Timestamp.from(Instant.now()));
                adminTokenService.saveOrUpdate(token);
                return new Data(adminTokenService.getTokenByToken(token.getToken()));
            } else {
                return new Data(new Exception("Identifiants incorrect"));
            }
        }
    }
}
