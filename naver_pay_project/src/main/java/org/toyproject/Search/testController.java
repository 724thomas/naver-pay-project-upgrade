package org.toyproject.Search;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.toyproject.signup.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class testController {

    @GetMapping(value = "/test")
    public String test(){
        System.out.println("GET");
        return "testView";
    }

    @PostMapping(value = "/test",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<UserDTO> testing(@RequestParam(required = false) String q, Model model) {
        System.out.println("POST");
        System.out.println(q);
        List<UserDTO> tempList = new ArrayList();
        UserDTO temp = new UserDTO("testId","testPwd","testName","000",1);
        UserDTO temp2 = new UserDTO("testId2","testPwd","testName","000",1);
        tempList.add(temp);
        tempList.add(temp2);
        return tempList;
    }
}
