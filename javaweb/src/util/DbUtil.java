package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//定义获得连接与关闭连接的过程
public class DbUtil {


    private static Connection cn=null;

    //获得连接
    public static Connection getConn(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/postgres","root","030114lyh");
            return  cn;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  null;
    }


    //关闭连接
    public static void  closeConn(){
        if(cn!=null){
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
