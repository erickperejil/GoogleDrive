package com.drive.drive.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.drive.modelos.Usuario;
import com.drive.drive.servicios.impl.UbicacionArchivoImpl;
import com.drive.drive.servicios.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestBody Usuario nvoUsuario){
        Usuario usuario = this.usuarioServiceImpl.crearUsuario(nvoUsuario);
        return usuario;
    }
}
