package org.toyproject.webcrawling;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WebCrawlingProductEntity {

    //Product
    private String productNameCompanyName;
    private String productName;
    private long productPrice;
    private int supplyPoint;

}
