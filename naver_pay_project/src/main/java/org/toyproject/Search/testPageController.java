package org.toyproject.Search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testPageController {
    @GetMapping(value = "/test")
    public String test(){
        System.out.println("GET");
        return "testView";
    }
}
