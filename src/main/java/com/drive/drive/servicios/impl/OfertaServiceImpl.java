package com.drive.drive.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drive.drive.modelos.Oferta;
import com.drive.drive.repositorios.OfertaRepository;
import com.drive.drive.servicios.OfertaService;

@Service
public class OfertaServiceImpl implements OfertaService {
    @Autowired
    private OfertaRepository ofertaRepository;
    @Override
    public Oferta crearOferta(Oferta oferta) {
        return ofertaRepository.save(oferta);
    }
    
}
