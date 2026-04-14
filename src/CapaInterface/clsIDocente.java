/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaInterface;

import CapaEntidad.clsEDocente;
import java.sql.ResultSet;
/**
 *
 * @author david
 */
public interface clsIDocente {
    
    // Método para obtener todos los docentes de la tabla
    public ResultSet mtdListarDocente();
    
    // Método para insertar un nuevo docente (Código de 6 caracteres)
    public boolean mtdAgregarDocente(clsEDocente objED);
    
    // Método para actualizar el nombre de un docente según su código
    public boolean mtdModificarDocente(clsEDocente objED);
    
    // Método para borrar un docente de la base de datos
    public boolean mtdEliminarDocente(clsEDocente objED);
    
    // Método para filtrar o buscar un docente específico
    public ResultSet mtdBuscarDocente(clsEDocente objED);
    
}
