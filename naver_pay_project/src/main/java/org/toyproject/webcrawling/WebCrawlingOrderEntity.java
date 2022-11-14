package org.toyproject.webcrawling;

public class WebCrawlingOrderEntity {

    //OrderInfo
    private String orderId;
    private String orderDate;
    private int orderQuantity;
    private int usedPoint;
    private int usedMoney;
    private long totalPayment;

    public WebCrawlingOrderEntity(){}

    public WebCrawlingOrderEntity(String orderId, String orderDate, int orderQuantity, int usedPoint, int usedMoney, long totalPayment) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderQuantity = orderQuantity;
        this.usedPoint = usedPoint;
        this.usedMoney = usedMoney;
        this.totalPayment = totalPayment;
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

    public int getUsedMoney() {
        return usedMoney;
    }

    public long getTotalPayment() {
        return totalPayment;
    }
}
