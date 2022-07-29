
package crud_ejemplo;

import java.sql.Connection;
import java.sql.DriverManager;


public class Crud_Ejemplo {
    Connection con;
    
    String url="jdbc:mysql://localhost:3306/crud_ejemplo";
    String user="root";
    String pass="";
    
    public Connection Conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=  DriverManager.getConnection(url,user,pass);
            System.out.println("finalizado");
        } catch (Exception e) {
            System.out.println(e);
        }      
        return con;
        
    }
    
    public static void main(String[] args) {
        Crud_Ejemplo con = new Crud_Ejemplo();
        System.out.println(con.Conectar());
    }

    
    
    
    
   
}
