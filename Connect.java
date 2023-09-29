
package Task.management.system;
import java.sql.*;
public class Connect {
    Connection c;
    public Statement s;
    public Connect(){
    try{
Class.forName("com.mysql.cj.jdbc.Driver");
c=DriverManager.getConnection("jdbc:mysql:///taskmanagement","root","Prashant@123");
s=c.createStatement();
    }catch(Exception e){
        e.printStackTrace();
    
    }
}

public void main(String args[]){

new Connect();
}

    PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}