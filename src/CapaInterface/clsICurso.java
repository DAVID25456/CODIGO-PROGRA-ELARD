/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaInterface;

import CapaEntidad.clsECurso;
import java.sql.ResultSet;

/**
 *
 * @author david
 */
public interface clsICurso {
    
    // Método para obtener todos los cursos registrados
    public ResultSet mtdListarCurso();

    // Método para registrar un nuevo curso
    public boolean mtdAgregarCurso(clsECurso objEC);

    // Método para actualizar los datos (nombre, créditos, prerrequisito) de un curso
    public boolean mtdModificarCurso(clsECurso objEC);

    // Método para eliminar un curso según su código
    public boolean mtdEliminarCurso(clsECurso objEC);

    // Método para buscar un curso específico por su código
    public ResultSet mtdBuscarCurso(clsECurso objEC);
    
}
