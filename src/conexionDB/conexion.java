/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author julio
 */
public class conexion {
    String url = "jdbc:mysql://localhost:3306/"; //Direccion de la basde de datos (IP:puerto)
    String db = "prueba1";  //Nombre de la Base de Datos
    String usuario = "root";
    String contrasena = "";
    String driver = "com.mysql.cj.jdbc.Driver";

    Connection jdbc;
    public conexion() {
    }

    public Connection conectar(){
        try {
            Class.forName(driver);
            jdbc = DriverManager.getConnection(url+db,usuario,contrasena);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("No se conecto a la base de datos "+e);
        }
        return jdbc;
    }
    
    public void desconeccion(){
        try {
            jdbc.close();
            System.out.println("Coneccion finalisada con exito");
        } catch (SQLException e) {
            System.out.println("Error al filanisa la coneccion "+e);
        }
    }
}
