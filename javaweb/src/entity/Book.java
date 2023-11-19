package entity;

import java.sql.Date;//java.util.Date的子类  专用于数据库操作

//实体类 javaBean entity 对应数据表设计的数据类
public class Book {
    //属性对应列去设计
    private Integer bookid;
    private String title;
    private String author;
    private String publisher;
    private Double price;

    public Integer getbookid() {
        return bookid;
    }
    public void setbookid(Integer bookid) {
        this.bookid = bookid;
    }
    public String gettitle() {
        return title;
    }
    public void settitle(String title) {
        this.title = title;
    }
    public String getauthor() {
        return author;
    }
    public void setauthor(String author) {
        this.author = author;
    }
    public String getpublisher() {
        return publisher;
    }
    public void setpublisher(String publisher) {
        this.publisher = publisher;
    }
    public Double getprice() {
        return price;
    }
    public void setprice(Double price) {
        this.price = price;
    }

    public Book(Integer bookid, String title, String author, String publisher, Double price) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;

    }




    public Book() {

    }
    @Override
    public String toString() {
        return "Student [bookid=" + bookid + ", title=" + title + ", author=" + author + ", publisher=" + publisher
                + ", price=" + price + "]";
    }



}
