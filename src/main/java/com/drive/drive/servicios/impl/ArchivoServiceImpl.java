package com.drive.drive.servicios.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drive.drive.Dto.Carpeta;
import com.drive.drive.modelos.Archivo;
import com.drive.drive.modelos.Compartido;
import com.drive.drive.modelos.EstadoArchivo;
import com.drive.drive.modelos.TipoArchivo;
import com.drive.drive.modelos.UbicacionArchivo;
import com.drive.drive.modelos.Usuario;
import com.drive.drive.repositorios.ArchivoRepository;
import com.drive.drive.repositorios.CompartidoRepository;
import com.drive.drive.repositorios.EstadoArchivoRepositoy;
import com.drive.drive.repositorios.TipoArchivoRepository;
import com.drive.drive.repositorios.UbicacionArchivoRepository;
import com.drive.drive.repositorios.UsuarioRepository;
import com.drive.drive.servicios.ArchivoService;

@Service
public class ArchivoServiceImpl implements ArchivoService{

    @Autowired ArchivoRepository archivoRepository;
    @Autowired CompartidoRepository compartidoRepository;
    @Autowired UsuarioRepository usuarioRepository;
    @Autowired UbicacionArchivoRepository ubicacionArchivoRepository;
    @Autowired TipoArchivoRepository tipoArchivoRepository;
    @Autowired EstadoArchivoRepositoy estadoArchivoRepositoy;

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
        List<Archivo> listaArchivos = this.archivoRepository.findByTipoArchivo_IdTipoArchivoAndPropietario_IdUsuario(idPropietario, idPropietario);
        return listaArchivos;
    }

    @Override
    public Archivo obtenerArchivo(int idArchivo) {
        Archivo archivo = this.archivoRepository.findById(idArchivo).get();
        return archivo;
    }

    @Override
    public Archivo crearArchivo(Archivo archivo) {
        Usuario usuario = usuarioRepository.findById(archivo.getPropietario().getIdUsuario()).get();
        EstadoArchivo estado = estadoArchivoRepositoy.findById(archivo.getEstadoArchivo().getIdEstado()).get();
        TipoArchivo tipo = tipoArchivoRepository.findById(archivo.getTipoArchivo().getIdTipoArchivo()).get();
        UbicacionArchivo ubicacion = ubicacionArchivoRepository.findById(archivo.getUbicacionArchivo().getIdUbicacion()).get();

        archivo.setPropietario(usuario);
        archivo.setEstadoArchivo(estado);
        archivo.setTipoArchivo(tipo);
        archivo.setUbicacionArchivo(ubicacion);
        return this.archivoRepository.save(archivo);
    }

    @Override
    public Archivo crearCarpeta(Carpeta carpeta) {
        Archivo nvoCarpeta = new Archivo();
        nvoCarpeta.setTamano(0);
        nvoCarpeta.setNombre(carpeta.getNombre());
        nvoCarpeta.setPropietario(this.usuarioRepository.findById(carpeta.getPropietaro()).get());
        nvoCarpeta.setFechaCreacion(carpeta.getFechaCreacion());
        nvoCarpeta.setFechaAbierto(carpeta.getFechaCreacion());
        nvoCarpeta.setDescripcion("");
        nvoCarpeta.setUbicacionArchivo(this.ubicacionArchivoRepository.findById(carpeta.getUbicacion()).get());
        nvoCarpeta.setTipoArchivo(this.tipoArchivoRepository.findById(1).get()); //poner el id que corresponda a la carpetas
        this.archivoRepository.save(nvoCarpeta);
        return nvoCarpeta;
    }

    @Override
    public String extraerCarpeta(int idArchivo) {
        Archivo archivo = this.archivoRepository.findById(idArchivo).get();
        List<Archivo> archivos = this.archivoRepository.findByUbicacionArchivo_UbicacionPadre_IdUbicacion(archivo.getUbicacionArchivo().getIdUbicacion());
        for (Archivo elemento : archivos) {
            elemento.setUbicacionArchivo(archivo.getUbicacionArchivo());
        }

        return "Carpeta Extraida";
        
    
    }


    
}
