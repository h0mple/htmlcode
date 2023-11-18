import java.sql.*;
public class Lab3 {

    static DBUtil db=new DBUtil();
    protected static PreparedStatement pstm=db.getPs();;
    protected static Connection con= db.getConn();
//    protected static ResultSet rs=null;

    //增
    public static void insertU(User newUser,String tableName) throws Exception{
        String sql_insert="insert into "+tableName+"(username,pwd) values(?,?)";
//        System.out.print(newUser.username);
        //state.executeUpdate(sql_insert);
        pstm=con.prepareStatement(sql_insert);
        pstm.setString(1,newUser.username);
        pstm.setString(2,newUser.pwd);
        int r=pstm.executeUpdate();
        System.out.println("插入成功");
    }
    //删
    public static void deleteU(int id,String tableName) throws Exception{
        PreparedStatement pstm=null;
        String sql_delete="delete from "+tableName+" where id="+Integer.toString(id);
        pstm=con.prepareStatement(sql_delete);
        int r=pstm.executeUpdate();
        System.out.println("删除成功");
    }
    //改
    public static void updateU(int id,User uUser,String tableName)throws Exception{
        String sql_update="update "+tableName+" set username=?,pwd=? where id="+Integer.toString(id);
        pstm=con.prepareStatement(sql_update);
        pstm.setString(1,uUser.username);
        pstm.setString(2,uUser.pwd);
        int r=pstm.executeUpdate();
        System.out.println("修改成功");
    }
    //查
    public static void selectU(int id_begin,int id_end,String tabele_name)throws Exception{
        String sql_update="select username,pwd from "+tabele_name+" where id between "+id_begin+" and "+id_end;
        pstm=con.prepareStatement(sql_update);
        ResultSet rs=pstm.executeQuery(sql_update);
        while (rs.next()){
            System.out.println(rs.getString(1)+" "+rs.getString(2));
        }
        System.out.println("查询成功");
        db.closeCon(rs,pstm,con);
    }
    public static void closeDB(){
        try {
            db.closeCon(null,pstm,con);
            System.out.println("关闭");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

