package org.toyproject.webcrawling;

public class WebCrawlingProductEntity {

    //Product
    private String productNameCompanyName;
    private String productName;
    private long productPrice;
    private int supplyPoint;

    public WebCrawlingProductEntity(){}

    public WebCrawlingProductEntity(String productNameCompanyName, String productName, long productPrice, int supplyPoint) {
        this.productNameCompanyName = productNameCompanyName;
        this.productName = productName;
        this.productPrice = productPrice;
        this.supplyPoint = supplyPoint;
    }

    public String getProductNameCompanyName() {
        return productNameCompanyName;
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
}
