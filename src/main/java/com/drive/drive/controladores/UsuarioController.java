package com.drive.drive.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.drive.modelos.Usuario;
import com.drive.drive.servicios.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("api/cliente")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    public Usuario crearUsuario(@RequestBody Usuario nvoUsuario){
        return this.usuarioServiceImpl.crearUsuario(nvoUsuario);
    }
}
