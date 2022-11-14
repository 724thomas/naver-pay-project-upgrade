package org.toyproject.signup;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignUpController {

    @RequestMapping("/SignUp")
    public String signUpPage(){
        return "SignUp";
    }

    @RequestMapping("/login")
    public String signUp(@ModelAttribute("userDTO") UserDTO theDTO, Model model){
        System.out.println(theDTO.getUserName());
        return "Login";
    }
}
