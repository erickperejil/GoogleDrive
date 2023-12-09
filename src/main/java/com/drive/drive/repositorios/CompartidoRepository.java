package com.drive.drive.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drive.drive.modelos.Compartido;

public interface CompartidoRepository extends JpaRepository<Compartido, Integer> {
    List<Compartido> findByPropietario_IdUsuarioAndUsuarioreceptor_IdUsuario(int propietario, int Receptor);
}
