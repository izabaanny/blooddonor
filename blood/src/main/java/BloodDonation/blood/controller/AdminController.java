package BloodDonation.blood.controller;

import BloodDonation.blood.dao.AdminRepository;
import BloodDonation.blood.entity.Admin;
import BloodDonation.blood.service.BloodDonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class AdminController {
    @Autowired
    public BloodDonorService bloodDonorService;

    @GetMapping("/donationBlood")
    public String showRegistrationForm() {
        return "Registration";
    }
@SuppressWarnings("unused")
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("fName") String fName,
                            @ModelAttribute("lName") String lName,
                            @ModelAttribute("email") String email,
                            @ModelAttribute("contact") String contact,
                            @ModelAttribute("acontact") String acontact,
                            @ModelAttribute("bloodGroup") String bloodGroup,
                            @ModelAttribute("country") String country,
                            @ModelAttribute("state") String state,
                            @ModelAttribute("city") String city) {
        Admin bd = new Admin(fName, lName, email, contact, acontact, bloodGroup, country, state, city);
        System.out.println(bd);
        bloodDonorService.addUser(bd);
        if (bd != null) {
            return "redirect:/getUsers";
        } else {
            return "fail";
        }
    }

    @GetMapping("/getUsers")
    public String getAllUsers(Model model) {
        model.addAttribute("bloodBank", bloodDonorService.getUsers());
        return "BloodBank";
    }

    @GetMapping("/getBestMatch")
    public String showSearchForm() {
        return "BestMatch";
    }

    @GetMapping("/getUserByEmail/{email}")
    @ResponseBody
    public List<Admin> getUsersByEmail(@PathVariable String email) {
        return bloodDonorService.getUserByEmail(email);
    }

    @GetMapping("/getUserByBgNdState/{bloodGroup}/{state}")
    public String getUsersByBgState(@PathVariable String bloodGroup, @PathVariable String state, Model model) {
        model.addAttribute("bloodBank", bloodDonorService.getUserBYBgNdState(bloodGroup, state));
        return "BestMatchResult";
    }

    @GetMapping("/getUserByBg/{bloodGroup}")
    @ResponseBody
    public List<Admin> getUserByBg(@PathVariable String bloodgroup) {
        return bloodDonorService.getUserByBg(bloodgroup);
    }
}
