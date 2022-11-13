package org.toyproject.WebCrawling;

public class WebCrawlingCompanyEntity {


    //Company
    private String companyName;
    private String companyPhone;
    private String companyUrl;

    public WebCrawlingCompanyEntity(){}

    public WebCrawlingCompanyEntity(String companyName, String companyPhone, String companyUrl) {
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.companyUrl = companyUrl;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }
}
