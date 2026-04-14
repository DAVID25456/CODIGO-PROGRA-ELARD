/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaInterface;

import CapaEntidad.clsEClase;
import java.sql.ResultSet;

/**
 *
 * @author david
 */
public interface clsIClase {
    
    // Lista las clases realizando JOINs con empleado, curso y docente
    public ResultSet mtdListarClase();

    // Registra una nueva relación de clase
    public boolean mtdAgregarClase(clsEClase objEC);

    // Modifica los participantes o el curso de una clase específica
    public boolean mtdModificarClase(clsEClase objEC);

    // Elimina el registro de una clase por su ID
    public boolean mtdEliminarClase(clsEClase objEC);

    // Busca los detalles de una clase por su ID
    public ResultSet mtdBuscarClase(clsEClase objEC);
    
}
