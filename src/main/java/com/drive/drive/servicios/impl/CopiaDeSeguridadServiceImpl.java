package com.drive.drive.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drive.drive.modelos.CopiaDeSeguridad;
import com.drive.drive.repositorios.CopiaDeSeguridadRepository;
import com.drive.drive.servicios.CopiaDeSeguridadService;
@Service
public class CopiaDeSeguridadServiceImpl implements CopiaDeSeguridadService{

    @Autowired
    CopiaDeSeguridadRepository copiaDeSeguridadRepository;

    @Override
    public CopiaDeSeguridad crearCopiaDeSeguridad(CopiaDeSeguridad copiaDeSeguridad) {
        return copiaDeSeguridadRepository.save(copiaDeSeguridad);
    }

    @Override
    public CopiaDeSeguridad actualizarCopiaDeSeguridad(CopiaDeSeguridad copiaDeSeguridad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarCopiaDeSeguridad'");
    }

   
    @Override
    public String eliminarCopiaDeSeguridad(int idCopiaDeSeguridad) {
        CopiaDeSeguridad copiaDeSeguridad = this.copiaDeSeguridadRepository.findById(idCopiaDeSeguridad).get();
        if (copiaDeSeguridad != null) {
            this.copiaDeSeguridadRepository.delete(copiaDeSeguridad);
            return "eliminado";
        }
        return "copia no entregada";
    }

    @Override
    public CopiaDeSeguridad obtenerCopiaDeSeguridad(int copiaDeSeguridad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerCopiaDeSeguridad'");
    }

    @Override
    public List<CopiaDeSeguridad> obtenertodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenertodos'");
    }
    
}
