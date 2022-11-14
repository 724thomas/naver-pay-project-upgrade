//package org.toyproject.DTO;
//
//import org.toyproject.entity.UserEntity;
//
//
//public class UserDTO {
//    private String userId;
//    private String userPassword;
//    private String userName;
//    private String userPhoneNumber;
//    private int userPoint;
//
//    public UserDTO(){
//
//    }
//
//    public UserDTO(String userId, String userPassword) {
//        this.userId = userId;
//        this.userPassword = userPassword;
//    }
//
//    public UserDTO( String userID, String userPassword, String userName){
//        this.userId = userID;
//        this.userPassword = userPassword;
//        this.userName = userName;
//    }
//
//    public UserDTO(String userID, String userPassword, String userName, String userPhoneNumber, int userPoint) {
//        this.userId = userID;
//        this.userPassword = userPassword;
//        this.userName = userName;
//        this.userPhoneNumber = userPhoneNumber;
//        this.userPoint = userPoint;
//    }
//
//    public UserDTO(String userId, String userPassword, String userName, String userPhoneNumber) {
//        this.userId = userId;
//        this.userPassword = userPassword;
//        this.userName = userName;
//        this.userPhoneNumber = userPhoneNumber;
//    }
//
//    public UserEntity toEntity(){
//        return new UserEntity(userId, userPassword, userName, userPhoneNumber, String.valueOf(userPoint));
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getUserPassword() {
//        return userPassword;
//    }
//
//    public void setUserPassword(String userPassword) {
//        this.userPassword = userPassword;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getUserPhoneNumber() {
//        return userPhoneNumber;
//    }
//
//    public void setUserPhoneNumber(String userPhoneNumber) {
//        this.userPhoneNumber = userPhoneNumber;
//    }
//
//    public int getUserPoint() {
//        return userPoint;
//    }
//
//    public void setUserPoint(int userPoint) {
//        this.userPoint = userPoint;
//    }
//
//    @Override
//    public String toString() {
//        return "UserDTO{" +
//                "userSerialNum=" + userSerialNum +
//                ", userId='" + userId + '\'' +
//                ", userPassword='" + userPassword + '\'' +
//                ", userName='" + userName + '\'' +
//                ", userPhoneNumber='" + userPhoneNumber + '\'' +
//                ", userPoint=" + userPoint +
//                '}' ;
//    }
//}