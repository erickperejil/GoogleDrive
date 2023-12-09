package com.drive.drive.servicios;

import java.util.Date;
import java.util.List;

import com.drive.drive.modelos.Archivo;

public interface ArchivoService {
    

    public List<Archivo> obtenerTodosLosArchivos(int idPropietario);

    public List<Archivo> obtenerCarpetas (int idPropietario);

    public List<Archivo> obtenerArchivosPorTipo (int idPropietario, int tipo);

    public List<Archivo> obtenerArchivosPorPersonaPropietario (int idPropietario, int idPersona);

    public List<Archivo> obtenerArchivosporFecha(int idPropietario, Date Fecha);

    public List<Archivo> obtenerArchivosporUbicacion(int idPropietario, String idUbicacion);

    public List<Archivo> obtenerArchivosporEstado(int idPropietario, int idEstado);

    public List<Archivo> obtenerArchivosporNombre(int idPropietario, String Nombre);

    public List<Archivo> obtenerCarpetasporPersona(int idPropietario);
    
    public Archivo obtenerArchivo(int idArchivo);

}
