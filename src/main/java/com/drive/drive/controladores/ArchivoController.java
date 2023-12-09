package com.drive.drive.controladores;

import com.drive.drive.modelos.Archivo;
import com.drive.drive.servicios.impl.ArchivoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/archivos")
public class ArchivoController {

    @Autowired
    private ArchivoServiceImpl archivoServiceImpl;

    @GetMapping("/obtenerArchivos")
    public List<Archivo> obtenerTodosLosArchivos(@RequestParam(name = "user") int usuario) {
        return archivoServiceImpl.obtenerTodosLosArchivos(usuario);
    }

    @GetMapping("/obtenerCarpetas")
    public List<Archivo> obtenerCarpetas(@RequestParam(name = "user") int usuario) {
        return archivoServiceImpl.obtenerCarpetas(usuario);
    }

    @GetMapping("/PorTipo")
    public List<Archivo> obtenerArchivosPorTipo(@RequestParam(name = "user") int usuario,@RequestParam(name = "tipo") int tipo) {
        return archivoServiceImpl.obtenerArchivosPorTipo(usuario, tipo);
    }

    @PostMapping("/Crear")
    public Archivo crearArchivo(@RequestBody Archivo archivo) {
        return archivoServiceImpl.crearArchivo(archivo);
    }

}

