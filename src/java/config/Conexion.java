/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Nestor
 */
public class Conexion {
    Connection con;
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver") ;
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/registroweb", "root", "root");
        } catch (Exception e) {
        }
    }
    
    public Connection getConnection() {
        return con;
    }
    
}
