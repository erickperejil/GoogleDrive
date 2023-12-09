package com.drive.drive.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.drive.modelos.Oferta;
import com.drive.drive.servicios.impl.OfertaServiceImpl;

@RestController
@RequestMapping("api/oferta")
public class OfertaController {
    
    @Autowired
    private OfertaServiceImpl ofertaServiceImpl;

    @PostMapping("/crear")
    public Oferta crearOferta(@RequestBody Oferta nvaOferta){
        return this.ofertaServiceImpl.crearOferta(nvaOferta);
    }

}
