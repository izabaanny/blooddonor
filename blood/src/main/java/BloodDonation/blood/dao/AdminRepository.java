package BloodDonation.blood.dao;

import BloodDonation.blood.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
public interface AdminRepository extends JpaRepository <Admin,Integer> {
    public static List<Admin> findByEmail(String email){
        return null;
    }
    public static List<Admin> findByBloodGroup(String bloodGroup){
        return null;
    }
    public static List<Admin> findByBloodGroupAndState(String bloodGroup, String state){
       return null;
    }
}

