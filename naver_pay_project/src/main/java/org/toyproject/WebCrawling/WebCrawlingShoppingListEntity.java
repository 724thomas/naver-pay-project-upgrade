package org.toyproject.WebCrawling;

public class WebCrawlingShoppingListEntity {
    private static WebCrawlingShoppingListEntity webCrawlingShoppingListEntity = null;
    //User
    private String userId;
    private String userPw;
    private String userName;
    private String userPhone;
    private String userAddress;
    private String userPoint;
    //Company
    private String companyName;
    private String companyPhone;
    private String companyStore;
    private long businessNumber;
    //Product
    private String productName;
    private long productPrice;
    private int supplyPoint;
    //Payment
    private String paymentMethod;
    //OrderInfo
    private String orderId;
    private String orderDate;
    private int orderQuantity;
    private int usedPoint;
    private long orderTotalMoney;

    public static WebCrawlingShoppingListEntity getInstance() {
        if (webCrawlingShoppingListEntity == null) {
            webCrawlingShoppingListEntity = new WebCrawlingShoppingListEntity();
        }

        return webCrawlingShoppingListEntity;
    }

    public WebCrawlingShoppingListEntity(){}

    public WebCrawlingShoppingListEntity(String userId, String userPw, String userName, String userPhone, String userAddress, String userPoint, String companyName, String companyPhone, String companyStore, long businessNumber, String productName, long productPrice, int supplyPoint, String paymentMethod, String orderId, String orderDate, int orderQuantity, int usedPoint, long orderTotalMoney) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userPoint = userPoint;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.companyStore = companyStore;
        this.businessNumber = businessNumber;
        this.productName = productName;
        this.productPrice = productPrice;
        this.supplyPoint = supplyPoint;
        this.paymentMethod = paymentMethod;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderQuantity = orderQuantity;
        this.usedPoint = usedPoint;
        this.orderTotalMoney = orderTotalMoney;

        System.out.println("WebCrawlingShoppingListEntity{" +
                "userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userName='" + userName + '\'' +
                ", userTel='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPoint='" + userPoint + '\'' +
                ", companyName='" + companyName + '\'' +
                ", comPanyTel='" + companyPhone + '\'' +
                ", companyStore='" + companyStore + '\'' +
                ", businessNumber=" + businessNumber +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", supplyPoint=" + supplyPoint +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", orderQuantity=" + orderQuantity +
                ", usedPoint=" + usedPoint +
                ", orderTotalMoney=" + orderTotalMoney +
                '}');

    }

    public String getUserId() {
        return userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserPoint() {
        return userPoint;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public String getCompanyStore() {
        return companyStore;
    }

    public long getBusinessNumber() {
        return businessNumber;
    }

    public String getProductName() {
        return productName;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public int getSupplyPoint() {
        return supplyPoint;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public int getUsedPoint() {
        return usedPoint;
    }

    public long getOrderTotalMoney() {
        return orderTotalMoney;
    }


    @Override
    public String toString() {
        return "WebCrawlingShoppingListEntity{" +
                "userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userName='" + userName + '\'' +
                ", userTel='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPoint='" + userPoint + '\'' +
                ", companyName='" + companyName + '\'' +
                ", comPanyTel='" + companyPhone + '\'' +
                ", companyStore='" + companyStore + '\'' +
                ", businessNumber=" + businessNumber +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", supplyPoint=" + supplyPoint +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", orderQuantity=" + orderQuantity +
                ", usedPoint=" + usedPoint +
                ", orderTotalMoney=" + orderTotalMoney +
                '}';
    }
}
