/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.clsConexion;
import CapaEntidad.clsEAlumno;
import CapaInterface.clsIAlumno;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class clsNAlumno implements clsIAlumno{

    //INSTANCIA DE LA CONEXION
    clsConexion cn = new clsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public ResultSet mtdListarAlumno() {
        
        //SENTENCIA SQL PARA LISTAR INFORMACION DE LA TABLA
        String sql = "SELECT * FROM tbalumno";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean mtdAgregarAlumno(clsEAlumno objEA) {
        
        //SENTENCIA SQL PARA INSERTAR VALORES A LA TABLA
        String sql = "INSERT INTO tbalumno (codigo, nombre, direccion, telefono, email) VALUES (?,?,?,?,?)";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            //DEFINIR LOS VALORES A INSERTAR
            ps.setString(1, objEA.getCodigo());
            ps.setString(2, objEA.getNombre());
            ps.setString(3, objEA.getDireccion());
            ps.setString(4, objEA.getTelefono());
            ps.setString(5, objEA.getEmail());
            
            int n = ps.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdModificarAlumno(clsEAlumno objEA) {
        
        //SENTENCIA SQL PARA ACTUALIZAR LA INFORMACION DE UNA FILA DE LA TABLA
        //SE HACE REFERENCIA DE LA FILA A PARTIR DEL CODIGO
        String sql = "UPDATE tbalumno SET nombre=?, direccion=?, telefono=?, email=? WHERE codigo=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            //DEFINIR VALORES A MODIFICAR
            ps.setString(1, objEA.getNombre());
            ps.setString(2, objEA.getDireccion());
            ps.setString(3, objEA.getTelefono());
            ps.setString(4, objEA.getEmail());
            
            //ESTE ES EL VALOR DE REFERENCIA
            ps.setString(5, objEA.getCodigo());
            
            int n = ps.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdEliminarAlumno(clsEAlumno objEA) {
        
        //SENTENCIA SQL PARA ELIMINAR UNA FILA DE LA TABLA
        //SE HACE REFERENCIA DE LA FILA A PARTIR DEL CODIGO
        String sql = "DELETE FROM tbalumno WHERE codigo=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEA.getCodigo());
            
            int n = ps.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public ResultSet mtdBuscarAlumno(clsEAlumno objEA) {
        
        //SENTENCIA SQL PARA LISTAR LA INFORMACION
        //SEGUN LA REFERENCIA AL VALOR CODIGO
        String sql = "SELECT * FROM tbalumno WHERE codigo = ?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            // Pasamos el código que viene desde el objeto entidad
            ps.setString(1, objEA.getCodigo());

            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al buscar por código: " + e.getMessage());
            return null;
        }
        
    }
    
}
