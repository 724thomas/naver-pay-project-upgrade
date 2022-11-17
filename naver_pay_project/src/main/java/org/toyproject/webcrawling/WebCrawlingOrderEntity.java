package org.toyproject.webcrawling;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WebCrawlingOrderEntity {

    //OrderInfo
    private String orderId;
    private String orderDate;
    private int orderQuantity;
    private int usedPoint;
    private int usedMoney;
    private long totalPayment;

}
