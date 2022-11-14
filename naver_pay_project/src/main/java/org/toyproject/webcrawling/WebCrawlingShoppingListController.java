package org.toyproject.webcrawling;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.text.ParseException;
import java.util.List;

@Controller
public class WebCrawlingShoppingListController {

    private String naverUserId;
    private String naverUserPassword;

    @RequestMapping("/crawling")
    public String loading(){
        return "CrawlingLogin";
    }

    @RequestMapping("/loading")
    public String crawlingLogin(@RequestParam String userId, String userPassword, Model model){
        naverUserId =userId;
        naverUserPassword =userPassword;
        return "Loading";
    }
    @RequestMapping("/crawlingResult")
    public String naverLogin(Model model) throws ParseException, AWTException {
        List<WebCrawlingShoppingListEntity> theEntityList = WebCrawlingShoppingListService.getShoppingListFromWeb(naverUserId, naverUserPassword);
        model.addAttribute("crawlingResult",theEntityList);
        return "CrawlingResult";
    }


}
