package org.toyproject.webcrawling;

import lombok.Cleanup;
import org.h2.command.Prepared;
import org.springframework.stereotype.Repository;
import org.toyproject.DB.ConnectionPoolMgr;

import java.sql.*;


@Repository
public class WebCrawlingDAO {

    private static WebCrawlingDAO webCrawlingDAO = null;
    private ConnectionPoolMgr connectionPoolMgr;
    private Connection conn=null;
    private PreparedStatement stmt=null;
    private ResultSet rs=null;

    //UserTable   (OrderedProductHistoryEntity)






    //해당 기간사이 결제정보 가져오기
    public WebCrawlingDAO(){
        if (connectionPoolMgr == null) {
            connectionPoolMgr = ConnectionPoolMgr.getInstance();
        }
    }
    public static WebCrawlingDAO getInstance(){
        if (webCrawlingDAO ==null){
            webCrawlingDAO =new WebCrawlingDAO();
        }
        return webCrawlingDAO;
    }

    public void InsertCompanyInfo(WebCrawlingCompanyEntity cEntity, WebCrawlingUserEntity uEntity, WebCrawlingProductEntity pEntity, WebCrawlingOrderEntity oEntity) throws Exception {

        String INSERT_COMPANY_TABLE =
                "INSERT INTO COMPANY_TABLE(company_name, company_phone, company_url) " +
                        "SELECT ?,?,? " +
                        "WHERE NOT EXISTS (SELECT * FROM COMPANY_TABLE WHERE company_name = ?);";
        String INSERT_PRODUCT_TABLE=
                "INSERT INTO PRODUCT_TABLE(productname_companyname, product_name, product_price, supply_point, company_name) " +
                        "SELECT ?,?,?,?,? " +
                        "WHERE NOT EXISTS (SELECT * from PRODUCT_TABLE where productname_companyname=?);";
        String INSERT_USER_TABLE=
                "INSERT INTO USER_TABLE(user_id, user_pw, user_name, user_phone, user_point) " +
                        "SELECT ?,?,?,?,? " +
                        "WHERE NOT EXISTS (SELECT * FROM USER_TABLE WHERE user_id = ?);";
        String INSERT_ORDER_TABLE=
                "INSERT INTO ORDER_TABLE(order_id, order_date, order_quantity, used_point, used_money, total_payment, user_id, productname_companyname) " +
                        "SELECT ?,?,?,?,?,?,?,? " +
                        "WHERE NOT EXISTS (SELECT * FROM ORDER_TABLE WHERE order_id = ?);";

        @Cleanup Connection connection = connectionPoolMgr.getConnection();
        @Cleanup PreparedStatement stmt= connection.prepareStatement(INSERT_COMPANY_TABLE);
        stmt.setString(1, cEntity.getCompanyName());
        stmt.setString(2, cEntity.getCompanyPhone());
        stmt.setString(3, cEntity.getCompanyUrl());
        stmt.setString(4, cEntity.getCompanyName());
        stmt.executeUpdate();
        @Cleanup PreparedStatement stmt2=connection.prepareStatement(INSERT_USER_TABLE);
        stmt2.setString(1, uEntity.getUserId());
        stmt2.setString(2, uEntity.getUserPw());
        stmt2.setString(3, uEntity.getUserName());
        stmt2.setString(4, uEntity.getUserPhone());
        stmt2.setInt(5, uEntity.getUserPoint());
        stmt2.setString(6, uEntity.getUserId());
        stmt2.executeUpdate();
        @Cleanup PreparedStatement stmt3=connection.prepareStatement(INSERT_PRODUCT_TABLE);
        stmt3.setString(1, pEntity.getProductNameCompanyName());
        stmt3.setString(2, pEntity.getProductName());
        stmt3.setLong(3, pEntity.getProductPrice());
        stmt3.setInt(4, pEntity.getSupplyPoint());
        stmt3.setString(5, cEntity.getCompanyName());
        stmt3.setString(6, pEntity.getProductNameCompanyName());
        stmt3.executeUpdate();
        @Cleanup PreparedStatement stmt4=connection.prepareStatement(INSERT_ORDER_TABLE);
        stmt4.setString(1, oEntity.getOrderId());
        stmt4.setString(2, oEntity.getOrderDate());
        stmt4.setInt(3, oEntity.getOrderQuantity());
        stmt4.setInt(4, oEntity.getUsedPoint());
        stmt4.setInt(5, oEntity.getUsedMoney());
        stmt4.setLong(6, oEntity.getTotalPayment());
        stmt4.setString(7, uEntity.getUserId());
        stmt4.setString(8, pEntity.getProductNameCompanyName());
        stmt4.setString(9, oEntity.getOrderId());
        stmt4.executeUpdate();

//        try{
//            conn= connectionPoolMgr.getConnection();
//            stmt=conn.prepareStatement(INSERT_USER_TABLE);
//            stmt.setString(1, uEntity.getUserId());
//            stmt.setString(2, uEntity.getUserPw());
//            stmt.setString(3, uEntity.getUserName());
//            stmt.setString(4, uEntity.getUserPhone());
//            stmt.setInt(5, uEntity.getUserPoint());
//            stmt.setString(6, uEntity.getUserId());
//            stmt.executeUpdate();
//            stmt=conn.prepareStatement(INSERT_PRODUCT_TABLE);
//            stmt.setString(1, pEntity.getProductNameCompanyName());
//            stmt.setString(2, pEntity.getProductName());
//            stmt.setLong(3, pEntity.getProductPrice());
//            stmt.setInt(4, pEntity.getSupplyPoint());
//            stmt.setString(5, cEntity.getCompanyName());
//            stmt.setString(6, pEntity.getProductNameCompanyName());
//            stmt.executeUpdate();
//            stmt=conn.prepareStatement(INSERT_ORDER_TABLE);
//            stmt.setString(1, oEntity.getOrderId());
//            stmt.setString(2, oEntity.getOrderDate());
//            stmt.setInt(3, oEntity.getOrderQuantity());
//            stmt.setInt(4, oEntity.getUsedPoint());
//            stmt.setInt(5, oEntity.getUsedMoney());
//            stmt.setLong(6, oEntity.getTotalPayment());
//            stmt.setString(7, uEntity.getUserId());
//            stmt.setString(8, pEntity.getProductNameCompanyName());
//            stmt.setString(9, oEntity.getOrderId());
//            stmt.executeUpdate();
//            conn.commit();
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally{
//            connectionPoolMgr.freeConnection(conn, stmt);
//        }
    }
}
