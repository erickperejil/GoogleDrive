package com.drive.drive.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drive.drive.modelos.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByCorreo(String correo);
    Usuario findByCorreoAndContrasena(String correo, String contrasena);
}
