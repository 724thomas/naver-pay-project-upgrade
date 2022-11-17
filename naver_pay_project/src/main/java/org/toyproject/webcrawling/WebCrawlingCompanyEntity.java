package org.toyproject.webcrawling;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WebCrawlingCompanyEntity {

    //Company
    private String companyName;
    private String companyPhone;
    private String companyUrl;

    public WebCrawlingCompanyEntity(){}


}
