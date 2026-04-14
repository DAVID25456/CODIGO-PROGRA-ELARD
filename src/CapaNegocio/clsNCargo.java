/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.clsConexion;
import CapaEntidad.clsECargo;
import CapaInterface.clsICargo;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class clsNCargo implements clsICargo{

    // Instancia de la conexión
    clsConexion cn = new clsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public ResultSet mtdListarCargo() {
        
        String sql = "SELECT * FROM tbcargo";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al listar cargos: " + e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean mtdAgregarCargo(clsECargo objEC) {
        
        String sql = "INSERT INTO tbcargo (codigo, descripcion) VALUES (?,?)";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            // IMPORTANTE: Usamos setInt porque el código es entero
            ps.setInt(1, objEC.getCodigo());
            ps.setString(2, objEC.getDescripcion());
            
            int n = ps.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar cargo: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdModificarCargo(clsECargo objEC) {
        
        String sql = "UPDATE tbcargo SET descripcion=? WHERE codigo=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, objEC.getDescripcion());
            ps.setInt(2, objEC.getCodigo());
            
            int n = ps.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar cargo: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean mtdEliminarCargo(clsECargo objEC) {
        
        String sql = "DELETE FROM tbcargo WHERE codigo=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, objEC.getCodigo());
            
            int n = ps.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cargo: " + e.getMessage());
            return false;
        }
        
    }

    @Override
    public ResultSet mtdBuscarCargo(clsECargo objEC) {
        
        String sql = "SELECT * FROM tbcargo WHERE codigo=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, objEC.getCodigo());
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error al buscar cargo: " + e.getMessage());
            return null;
        }
        
    }
    
}
