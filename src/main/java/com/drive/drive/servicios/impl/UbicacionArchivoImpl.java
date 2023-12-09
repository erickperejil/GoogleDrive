package com.drive.drive.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drive.drive.modelos.UbicacionArchivo;
import com.drive.drive.repositorios.UbicacionArchivoRepository;
import com.drive.drive.repositorios.UsuarioRepository;
import com.drive.drive.servicios.UbicacionArchivoService;

@Service
public class UbicacionArchivoImpl implements UbicacionArchivoService {

    @Autowired UbicacionArchivoRepository ubicacionArchivoRepository;
    @Autowired UsuarioRepository usuarioRepository;

    @Override
    public UbicacionArchivo crearUbicacionesArchivo(int usuario) {
        UbicacionArchivo ubicacion = new UbicacionArchivo();
        ubicacion.setNombreUbicacionArchivo("Home");
        ubicacion.setUbicacionPadre(null);
        ubicacion.setUsuario(usuarioRepository.findById(usuario).get());

        return this.ubicacionArchivoRepository.save(ubicacion);
    }
    
}
