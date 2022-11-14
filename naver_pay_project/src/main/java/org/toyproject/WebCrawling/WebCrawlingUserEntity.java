package org.toyproject.WebCrawling;

public class WebCrawlingUserEntity {

    //User
    private String userId;
    private String userPw;
    private String userName;
    private String userPhone;
    private String userAddress;
    private int userPoint;

    public WebCrawlingUserEntity(){}

    public WebCrawlingUserEntity(String userId, String userPw, String userName, String userPhone, String userAddress, int userPoint) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userPoint = userPoint;
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

    public int getUserPoint() {
        return userPoint;
    }
}
