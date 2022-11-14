package org.toyproject.signup;

import org.springframework.context.annotation.Bean;

public class UserDTO {

    private String userId;
    private String userPassword;
    private String userName;
    private String userPhone;
    private int userPoint;

    public UserDTO(){}

    public UserDTO(String userId, String userPassword, String userName, String userPhone, int userPoint) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userPoint = userPoint;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }
}
