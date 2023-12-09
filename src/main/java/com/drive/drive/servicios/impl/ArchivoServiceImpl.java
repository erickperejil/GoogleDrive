package com.drive.drive.servicios.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drive.drive.modelos.Archivo;
import com.drive.drive.modelos.Compartido;
import com.drive.drive.repositorios.ArchivoRepository;
import com.drive.drive.repositorios.CompartidoRepository;
import com.drive.drive.servicios.ArchivoService;

@Service
public class ArchivoServiceImpl implements ArchivoService{

    @Autowired ArchivoRepository archivoRepository;
    @Autowired CompartidoRepository compartidoRepository;

    @Override
    public List<Archivo> obtenerTodosLosArchivos(int idPropietario) {
        List<Archivo> listaArchivos = this.archivoRepository.findByPropietario_IdUsuario(idPropietario);
        return listaArchivos;
    }

    @Override
    public List<Archivo> obtenerCarpetas(int idPropietario) {
        //el id tiene que ser el que corresponda con carpetas
        List<Archivo> listaCarpetas = this.archivoRepository.findByTipoArchivo_IdTipoArchivoAndPropietario_IdUsuario(idPropietario, 1);
        return listaCarpetas;
    }

    @Override
    public List<Archivo> obtenerArchivosPorTipo(int idPropietario, int tipo) {
        List<Archivo> listaArchivos = this.archivoRepository.findByTipoArchivo_IdTipoArchivoAndPropietario_IdUsuario(idPropietario, tipo);
        return listaArchivos;
    }

    @Override
    public List<Archivo> obtenerArchivosPorPersonaPropietario(int idPropietario, int idPersona) {
        List<Compartido> listaCompartidos = this.compartidoRepository.findByPropietario_IdUsuarioAndUsuarioreceptor_IdUsuario(idPropietario, idPersona);
        List<Archivo> listaArchivos = new LinkedList<Archivo>();
        for (Compartido compartido : listaCompartidos) {
            listaArchivos.add(compartido.getArchivo());
        }

        return listaArchivos;
    }

    @Override
    public List<Archivo> obtenerArchivosporFecha(int idPropietario, Date Fecha) {
        List<Archivo> listaArchivos = this.archivoRepository.findByFechaCreacionAndPropietario_IdUsuario(Fecha, idPropietario);
        return listaArchivos;
    }

    @Override
    public List<Archivo> obtenerArchivosporUbicacion(int idPropietario, String Ubicacion) {
        List<Archivo> listaArchivos = this.archivoRepository.findByUbicacionArchivo_NombreUbicacionArchivoAndPropietario_IdUsuario(Ubicacion, idPropietario);
        return listaArchivos;
    }

    @Override
    public List<Archivo> obtenerArchivosporEstado(int idPropietario, int idEstado) {
        List<Archivo> listaArchivos = this.archivoRepository.findByEstadoArchivo_IdEstadoAndPropietario_IdUsuario(idEstado, idPropietario);
        return listaArchivos;
    }

    @Override
    public List<Archivo> obtenerArchivosporNombre(int idPropietario, String Nombre) {
        List<Archivo> listaArchivos = this.archivoRepository.findByNombreAndPropietario_IdUsuario(Nombre, idPropietario);
        return listaArchivos;
    }

    @Override
    public List<Archivo> obtenerCarpetasporPersona(int idPropietario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerCarpetasporPersona'");
    }

    @Override
    public Archivo obtenerArchivo(int idArchivo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerArchivo'");
    }

    
}
