package org.toyproject.Search;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String testing(@RequestParam(required = false) String q) {
        System.out.println("POST");
        return q;
    }
}
