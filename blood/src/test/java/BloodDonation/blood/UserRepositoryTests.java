package BloodDonation.blood;

import BloodDonation.blood.dao.AdminRepository;
import BloodDonation.blood.entity.Admin;
import org.apache.catalina.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class UserRepositoryTests {
    @Autowired private AdminRepository repo;
    @Test
    public void testAddNew(){
        Admin admin = new Admin();
        admin.setfName("izabayo");
        admin.setlName("anne");
        admin.setEmail("izabaanny@gmail.com");
        admin.setContact("o789506287");
        admin.setaContact("nnn");
        admin.setBloodGroup("A");
        admin.setCountry("Rwanda");
        admin.setState("kigali");
        admin.setCity("kigali");
        Admin savedAdmin = repo.save(admin);

        Assertions.assertThat(savedAdmin).isNotNull();
        Assertions.assertThat(savedAdmin.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll(){
        List<Admin> admin = repo.findAll();
        Assertions.assertThat(admin).hasSizeGreaterThan(0);

        for (Admin admin1 : admin) {
            System.out.println(admin1);
        }
    }
    @Test
    public void testUpdate(){
        Integer userId =1;
        Optional<Admin> optionalAdmin= repo.findById(userId);
        repo.findById(userId);
        Admin admin = optionalAdmin.get();
        admin.setEmail("izabayo.anne@auca.ac.rw");
        repo.save(admin);
        Admin updatedAdmin = repo.findById(userId).get();
        Assertions.assertThat(updatedAdmin.getEmail()).isEqualTo("anne.izabayo@auca.ac.rw");

    }
    @Test
    public void testGet(){
        Integer userId =2;
        Optional<Admin> optionalAdmin= repo.findById(userId);
        Assertions.assertThat(optionalAdmin).isPresent();
        System.out.println(optionalAdmin.get());
    }
    @Test
    public void testDelete(){
        Integer userId =2;
        repo.deleteById(userId);
        Optional<Admin> optionalAdmin= repo.findById(userId);
        Assertions.assertThat(optionalAdmin).isNotPresent();
    }
}
