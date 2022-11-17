package org.toyproject.webcrawling;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WebCrawlingCompanyEntity {

    //Company
    private String companyName;
    private String companyPhone;
    private String companyUrl;

}
