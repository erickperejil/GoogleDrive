package com.drive.drive.servicios;

import java.util.List;

import com.drive.drive.modelos.CopiaDeSeguridad;
import com.drive.drive.modelos.Usuario;

public interface CopiaDeSeguridadService {
    
    public CopiaDeSeguridad crearCopiaDeSeguridad(CopiaDeSeguridad copiaDeSeguridad);

    public CopiaDeSeguridad actualizarCopiaDeSeguridad(CopiaDeSeguridad copiaDeSeguridad);

    public CopiaDeSeguridad obtenerCopiaDeSeguridad(int copiaDeSeguridad);

    public List<CopiaDeSeguridad> obtenertodos();

    public String eliminarCopiaDeSeguridad(int idCopiaDeSeguridad);


}
