package org.toyproject.Search;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.toyproject.signup.UserDTO;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class testController {



    @GetMapping("/Searchs")
    public List<SearchDTO> Search2(@RequestParam HashMap<String,String> q) {
        SearchService theService = SearchService.getInstance();
        System.out.println("This part works");
        System.out.println("the string q is " + q.get("q"));
       // q="구글";
        try{
            return theService.search(q.get("q"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
