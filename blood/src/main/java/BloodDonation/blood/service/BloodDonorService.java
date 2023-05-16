package BloodDonation.blood.service;

import BloodDonation.blood.dao.AdminRepository;
import BloodDonation.blood.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BloodDonorService {
@Autowired
    private AdminRepository adminRepository;
@PostConstruct
    public void initDb(){
    List<Admin> users = new ArrayList<>();
    users.add(new Admin("izabayo","Anne","izabaanny@gmail.com","0789506287","NA","A+","India","madhya pradesh","jabalpur"));
    users.add(new Admin("Ghanshyam", "Ram", "shyam@gmail.com","1234567891","NA","B+","India", "Goa", "City"));
    users.add(new Admin("Ghanshyam", "Ram", "shyam@gmail.com","1234567891","NA","B+","India", "Goa", "City"));
    users.add(new Admin("Ghanshyam", "Ram", "shyam@gmail.com","1234567891","NA","B+","India", "Goa", "City"));
    users.add(new Admin("Ghanshyam", "Ram", "shyam@gmail.com","1234567891","NA","B+","India", "Madhya Pradesh", "City"));
    users.add(new Admin("Natasha", "Romenoff", "rmnof@shield.com","1234567894","NA","B+","Country", "State", "City"));
adminRepository.saveAll(users);
}
public Admin addUser(Admin admin){
    return adminRepository.save(admin);
}
public Iterable<Admin> getUsers(){
    return adminRepository.findAll();
}
public List<Admin> getUserByEmail(String email){
  return AdminRepository.findByEmail(email);
}
public List<Admin>getUserBYBgNdState(String bloodGroup,String state){
    return AdminRepository.findByBloodGroupAndState(bloodGroup, state);

}
public List<Admin> getUserByBg(String bloodGroup){
    return AdminRepository.findByBloodGroup(bloodGroup);
}
}
