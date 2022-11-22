package org.toyproject.Search;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.toyproject.signup.UserDTO;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class testController {



    @GetMapping("/test/test")
    public List<SearchDTO> testing(@RequestParam(required = false) String q) {
        List<SearchDTO> tempList = new ArrayList();
        System.out.println("Controller Testing");
        SearchDTO temp = new SearchDTO("abc","www.abc.com","this is abc");
        SearchDTO temp2 = new SearchDTO("def","www.def.com","this is def");
        tempList.add(temp);
        tempList.add(temp2);
        return tempList;
    }
}
