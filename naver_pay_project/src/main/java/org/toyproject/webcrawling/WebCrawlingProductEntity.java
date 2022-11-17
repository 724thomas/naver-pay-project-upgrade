package org.toyproject.webcrawling;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WebCrawlingProductEntity {

    //Product
    private String productNameCompanyName;
    private String productName;
    private long productPrice;
    private int supplyPoint;

}
