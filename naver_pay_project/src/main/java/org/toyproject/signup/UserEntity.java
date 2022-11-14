package org.toyproject.signup;

public class UserEntity {
    private String userId;
    private String userPassword;
    private String userName;
    private String userPhone;
    private int userPoint;

    public UserEntity(String userId, String userPassword, String userName, String userPhone, int userPoint) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userPoint = userPoint;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public int getUserPoint() {
        return userPoint;
    }
}
