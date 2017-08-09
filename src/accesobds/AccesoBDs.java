/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesobds;

/**
 *
 * @author miltonlab
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBDs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Driver JDBC cargado !!!");
        } catch (Exception ex){
            System.out.println("Error al cargar de driver:" + ex);
        }
        
        try{
            String urldb = "jdbc:derby://localhost:1527/libreria";
            Connection con = DriverManager.getConnection(urldb, "root", "root");
            System.out.println("Conexion exitosa a la BD 'libreria' !!!");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM ROOT.libros");
            while (rs.next()){
                int intId = rs.getInt("id");
                String strTitulo = rs.getString("titulo");
                String strEditorial = rs.getString("editorial");
                System.out.printf("%d %s %s \n", intId, strTitulo, strEditorial);
            }
            
        }catch (SQLException sqlex) {
            System.out.println("Error al conectar a la Base de Datos 'libreria': " + sqlex);
        }
        
    }
    
}
