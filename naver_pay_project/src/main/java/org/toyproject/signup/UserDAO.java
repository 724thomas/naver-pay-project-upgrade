package org.toyproject.signup;

import org.toyproject.DB.ConnectionPoolMgr;
import org.toyproject.webcrawling.WebCrawlingDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private static UserDAO userDAO=null;

    private static WebCrawlingDAO webCrawlingDAO = null;
    private ConnectionPoolMgr connectionPoolMgr;
    private Connection conn=null;
    private PreparedStatement stmt=null;
    private ResultSet rs=null;

    private static final String SELECT_USER_WITHIDANDPASSWORD=
            "SELECT * FROM user_table WHERE user_id = ? AND user_pw = ?";

    private static final String INSERT_USER=
            "INSERT INTO user_table (user_id, user_pw, user_name, user_phone, user_point) VALUES (?,?,?,?,?)";

    public UserDAO(){
        if (connectionPoolMgr==null){
            connectionPoolMgr = ConnectionPoolMgr.getInstance();
        }
    }

    public static UserDAO getInstance(){
        if (userDAO==null){
            userDAO = new UserDAO();
        }
        return userDAO;
    }
    public void insertUser(UserEntity theEntity){
        try{
            conn=connectionPoolMgr.getConnection();
            stmt = conn.prepareStatement(INSERT_USER);
            stmt.setString(1,theEntity.getUserId());
            stmt.setString(2,theEntity.getUserPassword());
            stmt.setString(3,theEntity.getUserName());
            stmt.setString(4,theEntity.getUserPhone());
            stmt.setInt(5,theEntity.getUserPoint());
            stmt.executeUpdate();
            System.out.println("User Data Insert SUCCESS.");
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public UserEntity searchUser(String userId, String userPassword){
        try{
            conn=connectionPoolMgr.getConnection();
            stmt = conn.prepareStatement(SELECT_USER_WITHIDANDPASSWORD);
            stmt.setString(1, userId);
            stmt.setString(2, userPassword);
            rs=stmt.executeQuery();
            while (rs.next()){
                String id = rs.getString("user_id");
                String pw = rs.getString("user_pw");
                String name = rs.getString("user_name");
                String phone = rs.getString("user_phone");
                int point = rs.getInt("user_point");
                UserEntity temp = new UserEntity(id,pw,name,phone,point);
                return temp;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            connectionPoolMgr.freeConnection(conn,stmt,rs);
        }
        return null;
    }
}
