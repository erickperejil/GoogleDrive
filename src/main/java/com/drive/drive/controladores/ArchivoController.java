package com.drive.drive.controladores;

import com.drive.drive.Dto.Carpeta;
import com.drive.drive.modelos.Archivo;
import com.drive.drive.servicios.ArchivoService;
import com.drive.drive.servicios.impl.ArchivoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/archivos")
public class ArchivoController {

    @Autowired
    private ArchivoServiceImpl archivoServiceImpl;

    @GetMapping("/obtenerTodos")
    public List<Archivo> obtenerTodasListas(){
        return this.archivoServiceImpl.obtenertodos();
    }

    @GetMapping("/obtenerArchivos")
    public List<Archivo> obtenerTodosLosArchivos(@RequestParam(name = "user") int usuario) {
        return archivoServiceImpl.obtenerTodosLosArchivos(usuario);
    }

    @GetMapping("/obtenerCarpetas")
    public List<Archivo> obtenerCarpetas(@RequestParam(name = "user") int usuario) {
        return archivoServiceImpl.obtenerCarpetas(usuario);
    }

    @GetMapping("/porTipo")
    public List<Archivo> obtenerArchivosPorTipo(@RequestParam(name = "user") int usuario,@RequestParam(name = "tipo") int tipo) {
        return archivoServiceImpl.obtenerArchivosPorTipo(usuario, tipo);
    }

    @GetMapping("/persona")
    public List<Archivo> obtenerArchivosPorPersonaPropietario(@RequestParam(name = "user") int usuario,@RequestParam(name = "owner") int owner) {
        return archivoServiceImpl.obtenerArchivosPorPersonaPropietario(usuario, owner);
    }

    @GetMapping("/fecha")
    public List<Archivo> obtenerArchivosporFecha(@RequestParam(name = "user") int usuario,@RequestParam(name = "date") Date date) {
        return archivoServiceImpl.obtenerArchivosporFecha(usuario, date);
    }

    @GetMapping("/ubicacion")
    public List<Archivo> obtenerArchivosporUbicacion(@RequestParam(name = "user") int usuario,@RequestParam(name = "date") String ubicacion) {
        return archivoServiceImpl.obtenerArchivosporUbicacion(usuario, ubicacion);
    }
    
    @GetMapping("/estado")
    public List<Archivo> obtenerArchivosporEstado(@RequestParam(name = "user") int usuario,@RequestParam(name = "state") int state) {
        return archivoServiceImpl.obtenerArchivosporEstado(usuario, state);
    }

    @GetMapping("/nombre")
    public List<Archivo> obtenerArchivosporNombre(@RequestParam(name = "user") int usuario,@RequestParam(name = "name") String name) {
        return archivoServiceImpl.obtenerArchivosporNombre(usuario, name);
    }

    @GetMapping("/obtenerArchivo")
    public Archivo obtenerArchivo(@RequestParam(name = "archivo") int archivo) {
        return archivoServiceImpl.obtenerArchivo(archivo);
    }

    @PostMapping("/crearCarpeta")
    public Archivo crearCarpeta(@RequestBody Carpeta carpeta) {
        return archivoServiceImpl.crearCarpeta(carpeta);
    }

    @GetMapping("/extraerCarpeta")
    public String extraerCarpeta(@RequestParam(name = "archivo") int archivo) {
        return archivoServiceImpl.extraerCarpeta(archivo);
    }


    @PostMapping("/crear")
    public Archivo crearArchivo(@RequestBody Archivo archivo) {
        return archivoServiceImpl.crearArchivo(archivo);
    }

    private final ArchivoService archivoService;

    
    public ArchivoController(ArchivoService archivoService) {
        this.archivoService = archivoService;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<Archivo>> obtenerArchivosPorNombre(@PathVariable String nombre) {
        List<Archivo> archivos = archivoService.obtenerArchivosPorNombre(nombre);

        if (!archivos.isEmpty()) {
            return ResponseEntity.ok(archivos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

