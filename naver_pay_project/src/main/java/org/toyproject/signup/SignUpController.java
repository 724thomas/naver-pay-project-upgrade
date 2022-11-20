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
        SignUpService theService = SignUpService.getInstance();
        int result = theService.userSignUp(theDTO); //1 success, 0 fail.
        if (result==0){
            return "SignUp";
        }else{
            return "loginForm";
        }
    }
}
