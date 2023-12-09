package com.drive.drive.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.drive.modelos.CopiaDeSeguridad;
import com.drive.drive.servicios.impl.CopiaDeSeguridadServiceImpl;

@RestController
@RequestMapping("api/copiaSeguridad")
public class CopiadeSeguridadController {
    
    @Autowired
    private CopiaDeSeguridadServiceImpl copiaDeSeguridadServiceImpl;

    @PostMapping("/crear")
    public CopiaDeSeguridad crearCopiaDeSeguridad(@RequestBody CopiaDeSeguridad nvaCopiaDeSeguridad){
        return this.copiaDeSeguridadServiceImpl.crearCopiaDeSeguridad(nvaCopiaDeSeguridad);
    }
    @GetMapping("/obtenerTodos")
    public List<CopiaDeSeguridad> obtenerTodasListas(){
        return this.copiaDeSeguridadServiceImpl.obtenertodos();
    }

    @GetMapping("/buscar/{idUsuario}")
    public CopiaDeSeguridad buscarCopiaDeSeguridad(@PathVariable(name = "idCopiaDeSeguridad")int idCopiaDeSeguridad){
        return this.copiaDeSeguridadServiceImpl.obtenerCopiaDeSeguridad(idCopiaDeSeguridad);
    }
}
