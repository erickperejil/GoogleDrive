package com.drive.drive.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drive.drive.Dto.Login;
import com.drive.drive.modelos.Genero;
import com.drive.drive.modelos.Usuario;
import com.drive.drive.repositorios.GeneroRepository;
import com.drive.drive.repositorios.UsuarioRepository;
import com.drive.drive.servicios.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private GeneroRepository generoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        if (correoExistente(usuario.getCorreo())) {
            throw new IllegalArgumentException("Ya existe un usuario con este correo");
        }
        Genero genero = this.generoRepository.findById(usuario.getGenero().getIdGenero()).get();
        usuario.setGenero(genero);
        usuarioRepository.save(usuario);
        
        return usuario; 
    }

    public boolean correoExistente(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }

    @Override
    public Usuario obtenerUsuario(int Usuario) {
        return this.usuarioRepository.findById(Usuario).get();
    }

    @Override
    public Usuario actualizarUsuario(Usuario Usuario, int id) {
        Usuario UsuarioActualizar = this.usuarioRepository.findById(id).get();
        if(UsuarioActualizar != null) {
            UsuarioActualizar.setNombre(Usuario.getNombre());
            UsuarioActualizar.setCorreo(Usuario.getCorreo());
            UsuarioActualizar.setContrasena(Usuario.getContrasena());
            UsuarioActualizar.setApellido(Usuario.getApellido());
            UsuarioActualizar.setNumeroTelefonico(Usuario.getNumeroTelefonico());
            this.usuarioRepository.save(UsuarioActualizar);
            return UsuarioActualizar;
        }
        return null;
    }

    @Override
    public Usuario loginUsuario(Login usuario) {
        Usuario usuarioEncontrado = usuarioRepository.findByCorreoAndContrasena(usuario.getCorreo(), usuario.getContrasena());
        if (usuarioEncontrado != null) {
            return usuarioEncontrado;
        } 
        return null;
    }

    @Override
    public List<Usuario> obtenertodos() {
        return this.usuarioRepository.findAll();
    }
    
}
