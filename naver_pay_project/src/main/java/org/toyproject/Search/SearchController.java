package org.toyproject.Search;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SearchController {
    @GetMapping("/Search")
    public String Search(@RequestParam("searchKeyword") String keyword, Model model){
        System.out.println("Get");
        SearchService theService = SearchService.getInstance();
        List<SearchDTO> temp = null;
        try{
            temp = theService.search(keyword);
            System.out.println(temp);
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("searchKeyword",keyword);
        model.addAttribute("theDTOs", temp);
        return "SearchResult";
    }

    @PostMapping(value="/Search",
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<SearchDTO> Search2(@RequestParam(required = false) String q) {
        System.out.println("Post");
        SearchService theService = SearchService.getInstance();
        List<SearchDTO> temp = null;
        System.out.println("This part works");
        try{
            temp = theService.search(q);
            System.out.println("Controller Works");
        }catch (Exception e){
            e.printStackTrace();
        }
        return temp;
    }


//    @GetMapping("/SearchAgain")
//    public String SearchAgain(@RequestParam("searchKeyword") String keyword, Model model) {
//        SearchService theService = SearchService.getInstance();
//        List<SearchDTO> temp = null;
//        try {
//            temp = theService.search();
//            System.out.println(temp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        model.addAttribute("searchKeyword",keyword);
//        model.addAttribute("searchKeyword",keyword);
//        model.addAttribute("theDTOs", temp);
//        return "SearchResult";
//    }
}
