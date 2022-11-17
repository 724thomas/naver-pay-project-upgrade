package org.toyproject.webcrawling;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WebCrawlingOrderEntity {

    //OrderInfo
    private String orderId;
    private String orderDate;
    private int orderQuantity;
    private int usedPoint;
    private int usedMoney;
    private long totalPayment;

}
