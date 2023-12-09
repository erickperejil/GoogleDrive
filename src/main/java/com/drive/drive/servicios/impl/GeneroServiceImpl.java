package com.drive.drive.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drive.drive.modelos.Genero;
import com.drive.drive.repositorios.GeneroRepository;
import com.drive.drive.servicios.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public Genero crearGenero(Genero genero) {
        return generoRepository.save(genero);
    }
    
}
