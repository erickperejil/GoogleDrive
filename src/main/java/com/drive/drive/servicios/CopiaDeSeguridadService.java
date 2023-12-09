package com.drive.drive.servicios;

import java.util.List;

import com.drive.drive.modelos.CopiaDeSeguridad;

public interface CopiaDeSeguridadService {
    
    public CopiaDeSeguridad crearCopiaDeSeguridad(CopiaDeSeguridad copiaDeSeguridad);

    public CopiaDeSeguridad actualizarCopiaDeSeguridad(CopiaDeSeguridad copiaDeSeguridad);

    public List<CopiaDeSeguridad> obtenerCopiasDeSeguridad(int Usuario);

    public String eliminarCopiaDeSeguridad(int idCopiaDeSeguridad);

}
