public class MainDB {
    public static void main(String[] args) throws Exception {
        DBUtil db1=new DBUtil();
        User user1=new User("test3","1234567");
        User user2=new User("update","218808");
        Lab3 lab3=new Lab3();
        lab3.insertU(user1,"lab");
        lab3.deleteU(6,"test");
        lab3.updateU(3,user2,"test");
        lab3.selectU(2,4,"test");
        lab3.closeDB();
    }
}


