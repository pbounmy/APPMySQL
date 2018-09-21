package myapp.bmp.com.appmysql;
import java.sql.*;
public class DB {
    public static Connection getConnet(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://192.168.8.104:3306/db1";
            String user="root";
            String pwd="bounmy1234";
            Connection c = DriverManager.getConnection(url,user,pwd);
            return c;

        }catch (Exception e){
            return null;
        }
    }
}
