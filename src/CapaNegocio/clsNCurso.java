/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.clsConexion;
import CapaEntidad.clsECurso;
import CapaInterface.clsICurso;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class clsNCurso implements clsICurso{

    // Instancia de la conexión
    clsConexion cn = new clsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public ResultSet mtdListarCurso() {
        
        String sql = "SELECT * FROM tbcurso";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al listar cursos: " + e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean mtdAgregarCurso(clsECurso objEC) {
        
        String sql = "INSERT INTO tbcurso (codigo, nombre, creditos, prerequisito) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEC.getCodigo());
            ps.setString(2, objEC.getNombre());
            ps.setInt(3, objEC.getCreditos()); // Manejo de entero
            ps.setString(4, objEC.getPrerequisito());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar curso: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdModificarCurso(clsECurso objEC) {
        
        String sql = "UPDATE tbcurso SET nombre=?, creditos=?, prerequisito=? WHERE codigo=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEC.getNombre());
            ps.setInt(2, objEC.getCreditos());
            ps.setString(3, objEC.getPrerequisito());
            ps.setString(4, objEC.getCodigo());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar curso: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdEliminarCurso(clsECurso objEC) {
        
        String sql = "DELETE FROM tbcurso WHERE codigo=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEC.getCodigo());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar curso: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public ResultSet mtdBuscarCurso(clsECurso objEC) {
        
        String sql = "SELECT * FROM tbcurso WHERE codigo=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEC.getCodigo());
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al buscar curso: " + e.getMessage());
            return null;
        }
        
    }
    
}
