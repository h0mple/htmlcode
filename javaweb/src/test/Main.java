package test;

import dao.BookDao;
import entity.Book;
import dao.BookDao;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        //调用Dao类完成数据库操作
        BookDao bdao = new BookDao();
        Book book= new Book(207,"大学英语","LYH","LYH",20.00);
        boolean result =bdao.addBook(book);
        System.out.println(result);

    }
}
