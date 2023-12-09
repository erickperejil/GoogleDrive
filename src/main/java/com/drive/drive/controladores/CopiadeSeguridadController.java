package com.drive.drive.controladores;

import org.springframework.beans.factory.annotation.Autowired;
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
}
