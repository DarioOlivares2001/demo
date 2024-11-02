// RecetaService.java
package com.example.demo.service;

import com.example.demo.model.Receta;
import com.example.demo.repository.RecetaRepository;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;


@Service
public class RecetaService {

    private final RecetaRepository recetaRepository;
    private static final Logger logger = LoggerFactory.getLogger(RecetaService.class);

    public RecetaService(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    public List<Receta> findAll() {
        logger.debug("Buscando todas las recetas");
        List<Receta> recetas = recetaRepository.findAll();
        logger.debug("Recetas encontradas: {}", recetas.size());
        logger.info("Lista de recetas: {}", recetas); // Para ver el contenido completo
        return recetas;
    }

    public Receta save(Receta receta) {
        return recetaRepository.save(receta);
    }
}
