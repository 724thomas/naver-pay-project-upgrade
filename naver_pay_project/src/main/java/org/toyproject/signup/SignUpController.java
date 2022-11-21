package org.toyproject.signup;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignUpController {

    @RequestMapping("/SignUp")
    public String signUpPage(){
        return "SignUp";
    }

    @PostMapping("/SignUp")
    public String signUp(@ModelAttribute("userDTO") UserDTO theDTO, Model model){
        SignUpService theService = SignUpService.getInstance();
//        int result = theService.userSignUp(theDTO); //1 success, 0 fail.
        int result=1;
        if (result==0){
            System.out.println("SignUp Failed");
            return "SignUp";
        }else{
            System.out.println("SignUp Success");
            return "loginForm";
        }
    }
}
