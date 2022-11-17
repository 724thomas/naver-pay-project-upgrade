package org.toyproject.webcrawling;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;

@Log4j2
public class WebCrawlingShoppingListService {

    private WebCrawlingShoppingListService webCrawlingShoppingListService=null;

    public WebCrawlingShoppingListService getInstance(){
        if (webCrawlingShoppingListService==null){
            webCrawlingShoppingListService=new WebCrawlingShoppingListService();
        }
        return webCrawlingShoppingListService;
    }

    public static void main(String[] args) throws Exception {
//        WebDriverManager.chromedriver().setup();
        getShoppingListFromWeb("724thomas","");
    }
    public static List<WebCrawlingShoppingListEntity> getShoppingListFromWeb(String naverId, String naverPassword) throws Exception {
        List<WebCrawlingShoppingListEntity> WebCrawlingShoppingListEntities = new ArrayList<>();

        WebDriver driver = null;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");\
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.get("https://nid.naver.com/nidlogin.login?url=http://pay.naver.com");

        String loginUserId = naverId;
        String loginUserPassword = naverPassword;

        /*아이디 입력*/
        WebElement id = driver.findElement(By.cssSelector("#id"));
        id.click();
        copyAndPaste(loginUserId);

        /*비밀번호 입력*/
        WebElement pw = driver.findElement(By.cssSelector("#pw"));
        pw.click();
        copyAndPaste(loginUserPassword);

        /*로그인*/
        WebElement login_btn = driver.findElement(By.cssSelector("#log\\.org.toyproject.login"));
        login_btn.click();


        /*임의 값*/
        String userAddress = "강남구 역삼동 비왕빌딩 10층";
        String userPw = randomPassword();
        String userName = randomName();
        String userPhone = randomTel();
        String paymentMethod = randomPaymentMethod();

        /*주문내역 페이지 크롤링*/
        Document doc = Jsoup.parse(driver.getPageSource());
        Elements elements;
        elements = doc.select("p.name");
        int numOfOrders = elements.size();

        elements = doc.select("span.user_id");
        String userId = elements.text(); //유저 아이디

        elements = doc.select("div.member_sc");
        String userPoint =elements.text().split(" 포인트 ")[1].replace("원",""); //현재 유저 포인트

        Elements productNameList = doc.select("p.name");
        String productName; //제품명

        Elements orderTotalMoneyAndDateList = doc.select("ul.info");
        long orderTotalMoney; //총 제품가격
        String orderDate; //주문 날짜

        Elements sellerList = doc.select("span.seller");
        String companyName; //판매자

        Elements sellerTelList = doc.select("span.tel");
        String companyPhone; //판매자 대표번호


        Elements urlLinks = doc.select("a.goods"); //주문제품들의 url들
        ArrayList<String> realLinks = new ArrayList<>();
        ArrayList<String> realproductNames = new ArrayList<>();
        ArrayList<String> realOrderDate = new ArrayList<>();
        ArrayList<String> realCompanyName = new ArrayList<>();
        ArrayList<String> realCompanyPhone = new ArrayList<>();


        for (int i=0; i<numOfOrders; i++){
            if(!realLinks.contains(getRealUrl(urlLinks.get(i).attr("href")))){
                realLinks.add(getRealUrl(urlLinks.get(i).attr("href"))); //url
                realproductNames.add(productNameList.get(i).text()); //제품명
                realOrderDate.add(orderTotalMoneyAndDateList.get(i).text().split(" 상품구매날짜 ")[1].replace(".","-")); //주문날짜
                realCompanyName.add(sellerList.get(i).text()); //회사명
                realCompanyPhone.add(sellerTelList.get(i).text()); //회사 대표번호
            }else{
                realproductNames.set(realproductNames.size()-1,productNameList.get(i).text());
            }
        }


        for (int i=0; i<realLinks.size(); i++){
//        for (int i=0; i<4; i++){

            productName = realproductNames.get(i); //제품명
            orderDate=realOrderDate.get(i); //주문 날짜

            companyName=realCompanyName.get(i); //판매자
            companyPhone=realCompanyPhone.get(i); //판매자 대표번호
            long businessNumber = randomBusinessNumber(); //사업자 번호

            /*상세페이지 페이지 크롤링*/
//            String productUrl=getRealUrl(urlLinks.get(i).attr("href"));
            String productUrl=realLinks.get(i);
            driver.get(productUrl);
            doc = Jsoup.parse(driver.getPageSource());

            elements = doc.select("dd.pdb");
            if (!elements.text().equals("")){
                userName = elements.text().split(" ")[0]; //userName
                userPhone =elements.text().split(" ")[1]; //userPhone
            };

            elements = doc.select("a.seller_inquiry");
            String companyUrl; //companyUrl
            if (elements.attr("href").equals("#")){
                companyUrl = "No store url";
            }else{
                companyUrl = elements.attr("href");
            }

            elements = doc.select("span.p_color_green");
            int supplyPoint=0;
            try{
                supplyPoint = Integer.parseInt(elements.text().split(" ")[1].replaceAll("[,원]","")); //supplyPoint
            }catch (Exception e){
                e.printStackTrace();
            }

            elements = doc.select("strong.pointcol");
            String orderId=elements.text(); //orderId

            elements = doc.select("td.money");
            int orderQuantity =Integer.parseInt(elements.text().split(" ")[1].replaceAll("[()개]","")); //orderQuantity

            elements = doc.select("em.thm");
            int usedMoney=Integer.parseInt(elements.text().split(" ")[elements.text().split(" ").length-1].replace(",",""));
            int usedPoint;
            if (elements.text().split(" ")[elements.text().split(" ").length-2].equals(elements.text().split(" ")[elements.text().split(" ").length-1])){
                usedPoint=0;
            }else{
                usedPoint=Integer.parseInt(elements.text().split(" ")[elements.text().split(" ").length-2].replace(",",""));
            }
//            orderTotalMoney=Long.parseLong(elements.text().split(" ")[elements.text().split(" ").length-3].replace(",",""));

            elements=doc.select("li.final_payment_price");
            orderTotalMoney=Long.parseLong(elements.text().split(" ")[1].replaceAll("[,원]",""));
            long productPrice = orderTotalMoney/ orderQuantity;


//            System.out.println("로그인아이디:"+userId+" 비밀번호:"+userPw+ "이름:"+userName+" 연락처:"+userPhone+" 주소:"+userAddress+" 포인트잔액:"+userPoint);
//            System.out.println("회사명:"+companyName+" 회사번호:"+companyPhone+" 회사URL:"+companyUrl+" 사업자번호:"+businessNumber);
//            System.out.println(" 제품명:"+productName+" 제공포인트:"+supplyPoint+" 제품가격:"+productPrice);
//            System.out.println(" 결제방법:"+paymentMethod);
//            System.out.println(" 주문번호:"+orderId+" 주문 날짜:"+orderDate+" 주문수량:"+orderQuantity+" 사용포인트:"+usedPoint+" 결제금액:"+usedMoney+" 총 결제금액:"+orderTotalMoney);
//            System.out.println("------------------------------------------------");
//            WebCrawlingUserEntity uEntity = new WebCrawlingUserEntity(
//                    userId, userPw, userName, userPhone,userAddress,Integer.parseInt(userPoint)
//            );
//            WebCrawlingOrderEntity oEntity = new WebCrawlingOrderEntity(
//                    orderId,orderDate,orderQuantity,usedPoint, usedMoney, orderTotalMoney
//            );
//            WebCrawlingProductEntity pEntity = new WebCrawlingProductEntity(
//                    productNameCompanyName,productName,productPrice,supplyPoint
//            );
//            WebCrawlingCompanyEntity cEntity = new WebCrawlingCompanyEntity(
//                    companyName,companyPhone,companyUrl
//            );

            WebCrawlingUserEntity uEntity = WebCrawlingUserEntity.builder()
                    .userId(userId)
                    .userPw(userPw)
                    .userName(userName)
                    .userPhone(userPhone)
                    .userAddress(userAddress)
                    .userPoint(Integer.parseInt(userPoint))
                    .build();

            WebCrawlingOrderEntity oEntity = WebCrawlingOrderEntity.builder()
                    .orderId(orderId)
                    .orderDate(orderDate)
                    .orderQuantity(orderQuantity)
                    .usedPoint(usedPoint)
                    .usedMoney(usedMoney)
                    .totalPayment(orderTotalMoney)
                    .build();

            String productNameCompanyName = productName+companyName;
            WebCrawlingProductEntity pEntity = WebCrawlingProductEntity.builder()
                    .productNameCompanyName(productNameCompanyName)
                    .productName(productName)
                    .productPrice(productPrice)
                    .supplyPoint(supplyPoint)
                    .build();

            WebCrawlingCompanyEntity cEntity = WebCrawlingCompanyEntity.builder()
                    .companyName(companyName)
                    .companyPhone(companyPhone)
                    .companyUrl(companyUrl)
                    .build();


            WebCrawlingDAO theDao = WebCrawlingDAO.getInstance();
            theDao.InsertCompanyInfo(cEntity,uEntity,pEntity,oEntity);



            WebCrawlingShoppingListEntity temp = new WebCrawlingShoppingListEntity(
                    userId,userPw,userName,userPhone,userAddress,userPoint,companyName,companyPhone,companyUrl,businessNumber,productName,productPrice,supplyPoint,paymentMethod,orderId,orderDate,orderQuantity,usedPoint,orderTotalMoney
            );
            WebCrawlingShoppingListEntities.add(temp);
            log.info(WebCrawlingShoppingListEntities);
        }
        driver.quit();
        return WebCrawlingShoppingListEntities;
    }

    public static void copyAndPaste(String str) throws AWTException {
        StringSelection stringSelection = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static String getRealUrl(String str){
        if (str.substring(1,12).equals("orderStatus")){
            return ("https://order.pay.naver.com" + str);
        }else{
            return str;
        }
    }

    public static String randomPassword(){
        return String.valueOf( Math.round(Math.random()*10000));
    }
    public static String randomName(){
        return "4조"+ Math.round(Math.random()*100);
    }
    public static String randomTel(){
        return "010-" + Math.round(Math.random()*10000) + "-" + Math.round(Math.random()*10000);
    }
    public static long randomBusinessNumber(){
        return Math.round(Math.random()*10000000000L);
    }
    public static String randomPaymentMethod(){
        switch ((int)Math.round(Math.random()*3)){
            case 0: return "신용카드";
            case 1: return "체크카드";
            case 2: return "계좌이체";
            case 3: return "비자카드";
            default : return "";
        }
    }
}
