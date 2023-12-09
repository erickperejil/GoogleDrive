package com.drive.drive.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drive.drive.modelos.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {

    Optional<Genero> findById(Genero genero);

}
