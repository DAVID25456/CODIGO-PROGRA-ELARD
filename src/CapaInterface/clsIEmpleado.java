/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaInterface;

import CapaEntidad.clsEEmpleado;
import java.sql.ResultSet;

/**
 *
 * @author david
 */
public interface clsIEmpleado {
    
    // Método para listar empleados
    public ResultSet mtdListarEmpleado();
    
    // Método para agregar un nuevo empleado
    public boolean mtdAgregarEmpleado(clsEEmpleado objEE);
    
    // Método para modificar datos del empleado según su DNI
    public boolean mtdModificarEmpleado(clsEEmpleado objEE);
    
    // Método para eliminar (o dar de baja) un empleado según su DNI
    public boolean mtdEliminarEmpleado(clsEEmpleado objEE);
    
    // Método para buscar un empleado específico
    public ResultSet mtdBuscarEmpleado(clsEEmpleado objEE);
    
}
