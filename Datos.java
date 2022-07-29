
package crud_ejemplo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Datos {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Crud_Ejemplo conectar = new Crud_Ejemplo();
    
    
    public void menu()
    {
        
        while (true) 
        { 
            
            Scanner entrada = new Scanner(System.in);
            System.out.println("===================================");
            System.out.println("I       Menu principal             I");
            System.out.println("I 1.Consultar                      I");
            System.out.println("I 2.Crear                          I");
            System.out.println("I 3.Modificar                      I");
            System.out.println("I 4.Eliminar                       I");
             
            int repuesta = entrada.nextInt();
            
            switch (repuesta)
            {             
            case 1:
                listar();
                        
            break;
                     
                
            case 2:              
                crear(2100150, jeornimo, 15, zona);
                                
            break;
            
            
            case 3:
                Scanner scc = new Scanner(System.in);
                System.out.println("Ingrese Codigo para modificar usuario");
                 int usuario = scc.nextInt();
       
                 modificar(usuario, nombre, usuario, nombre);
                 System.out.println("se ha modificado correctamente");
            break;
            
            
            case 4:
                 int codigo = entrada.nextInt();                
                 eliminar(codigo);
                 System.out.println("El usuario ha sido elimado del registro");
            break;
           
            case 5:                
            System.exit(0);
            break;
            
            default:
            throw new AssertionError();          
            }           
        } 
    }
    
    public void listar(){
    
        String instruccion = "select * from producto";
        
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(instruccion);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getInt(3));
                System.out.println(rs.getString(4));
                System.out.println("---------------");
            }
            
        } catch (Exception e) {
        }
    
    }
    
    public void crear(int codigo, String nombre, int cantidad, String lugar_fabricacion){
    String sql = "insert into producto(lugar_fabricacion,nombre,cantidad,codigo) values (?,?,?,?)";
    
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setInt(3, cantidad);
            ps.setString(4, lugar_fabricacion);
            ps.executeUpdate();
            
            
        } catch (Exception e) {
        }
    
    
    }
    
    public void modificar(int codigo, String nombre, int cantidad, String lugar_fabricacion){
    
            String sql = "update producto set Nombre='" + nombre + "', Cantidad='" + cantidad + "', Lugar_Fabricacion='" + lugar_fabricacion + "' where Codigo ='" + codigo + "'";
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    
    
    }
    
    public void eliminar(int codigo){
        String sql = "delete from producto where Codigo = ?";
        try {
            
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    
    
    }
    public static void main(String[] args) {
        Datos bj = new Datos();
        bj.menu();
        
    }
    
}
