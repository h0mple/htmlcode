import java.sql.*;
public class DBUtil {
    public static String username=Config.getInstance().getValue("user");
    public static String password=Config.getInstance().getValue("pwd");
    public static PreparedStatement pstm=null;
    protected static Connection con=null;

    private static String url=Config.getInstance().getValue("url");
    public static Connection getConn(){

        try {
            Class.forName(Config.getInstance().getValue("driver"));
            con=DriverManager.getConnection(url,username,password);
            System.out.println("连接成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
    public PreparedStatement getPs(){
        return pstm;
    }

    public void closeCon(ResultSet rs,PreparedStatement pstm,Connection con) throws Exception{
        if(rs!=null){
            rs.close();
        }
        if(pstm!=null){
            pstm.close();
        }
        if(con!=null){
            con.close();
        }
    }
}

