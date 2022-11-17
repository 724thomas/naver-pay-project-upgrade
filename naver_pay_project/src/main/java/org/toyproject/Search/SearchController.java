package org.toyproject.Search;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    @GetMapping("/Search")
    public String Search(@RequestParam("searchKeyword") String keyword, Model model){
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
