package com.codebay.goldeneye;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Locale;

@Controller
public class WebController {  
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/email")
    public String email(String firstName , String surname,  String department, String office, Model model){
        String email = generateEmail(firstName, surname, department, office);
        model.addAttribute("email",email);
        return "email";
    }

    private String generateEmail(String firstName, String surname, String department , String office){
        char firstletter = firstName.charAt(0);
        String filteredName = filterWords(firstletter + surname);
        String email = filteredName + "." + department + "@" + office + ".goldeneye.com";
        email = email.toLowerCase(Locale.ROOT);

        return email;
    }

    private String filterWords(String word){
        //API logic not implement yet
        return word;
    }


}