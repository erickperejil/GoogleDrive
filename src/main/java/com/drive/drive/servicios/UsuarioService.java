package com.drive.drive.servicios;

import java.util.List;

import com.drive.drive.Dto.Login;
import com.drive.drive.modelos.Usuario;

public interface UsuarioService {
    
    public Usuario crearUsuario(Usuario usuario);

    public Usuario obtenerUsuario(int Usuario);

    public Usuario actualizarUsuario(Usuario Usuario, int id);

    public Usuario loginUsuario(Login usuario);

    public List<Usuario> obtenertodos();




}
