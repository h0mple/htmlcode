package dao;

import entity.Book;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


//Dao 数据操作对象 Data  access  Object
public class BookDao {
    // 为对应的表与实体类编写好需要的增 删 改 查方法

    // 添加 传入Student对象 完成将该对象添加到数据库 返回成功或失败
    public boolean addBook(Book book) {
        // 获得连接
        Connection cn = DbUtil.getConn();
        // 编写带占位符的预编译SQL语句
        String insert = "INSERT INTO books(bookid,title,author,publisher,price) VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ps = cn.prepareStatement(insert);// 创建工具时就传入预编译语句
            // 处理每个占位符对应的数据 ，要找准数据类型
            ps.setInt(1, book.getbookid());// 列的序号从1开始
            ps.setString(2, book.gettitle());
            ps.setString(3, book.getauthor());
            ps.setString(4, book.getpublisher());
            ps.setDouble(5, book.getprice());

            int result = ps.executeUpdate();// 执行操作
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // 关闭连接
            DbUtil.closeConn();
        }

        return false;// 如果有任何异常则返回false
    }

    // 修改 以ID为条件 允许修改其他所有列
    public boolean update(Book book) {
        // 获得连接
        Connection cn = DbUtil.getConn();
        // 编写带占位符的预编译SQL语句
        String update = "update books set  title=?,author=?,publisher=?,price=?  where bookid = ?";

        try {
            PreparedStatement ps = cn.prepareStatement(update);
            // 处理每个占位符对应的数据 ，要找准数据类型
            ps.setString(1,book.gettitle());// 列的序号从1开始
            ps.setString(2,book.getauthor());
            ps.setString(3,book.getpublisher());
            ps.setDouble(4,book.getprice());
            ps.setInt(5,book.getbookid());


            int result = ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DbUtil.closeConn();
        }
        return false;

    }

    // 删除
    // 修改 以ID为条件删除指定数据
    public boolean delete(Integer bookid) {
        // 获得连接
        Connection cn = DbUtil.getConn();
        // 编写带占位符的预编译SQL语句
        String delete = "delete from books where bookid = ?";

        try {
            PreparedStatement ps = cn.prepareStatement(delete);
            // 处理每个占位符对应的数据 ，要找准数据类型
            ps.setInt(1, bookid);// 列的序号从1开始
            int result = ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DbUtil.closeConn();
        }

        return false;

    }

    // 查询所有(返回由Student对象组成的ArrayList集合)
    public ArrayList<Book> queryAll() {
        // 获得连接
        Connection cn = DbUtil.getConn();
        ArrayList<Book> al = new ArrayList<Book>();//包含所有查询结果对象的集合

        String sql ="select * from books";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {//多行结果
                //每行结果都封装为对象
                Book book = new Book(
                        rs.getInt("bookid"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getDouble("price"));
                al.add(book);
            }

            return al;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DbUtil.closeConn();
        }

        return null;//出现异常返回null
    }

    // 按ID查询一个
    public Book querySingle(Integer bookid){
        // 获得连接
        Connection cn = DbUtil.getConn();

        try {
            //编写语句
            String single = "select * from books where bookid = ?";
            PreparedStatement ps = cn.prepareStatement(single);
            ps.setInt(1, bookid);

            //将查询结果的一行数据转化为一个Student对象
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {//最多只能有一行数据
                Book book = new Book(
                        rs.getInt("bookid"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getDouble("price"));
                return book;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DbUtil.closeConn();
        }

        return null;//如果出现异常直接返回null
    }
}
