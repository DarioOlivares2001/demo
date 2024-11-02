// RecetaController.java
package com.example.demo.controller;

import com.example.demo.model.Receta;
import com.example.demo.service.RecetaService;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;


import java.util.List;

@Controller
public class RecetaController {

    private final RecetaService recetaService;
    private static final Logger logger = LoggerFactory.getLogger(RecetaController.class);

    public RecetaController(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    @GetMapping("/recetas")
    public List<Receta> listRecetas(Model model) {
        logger.debug("Entrando en listRecetas()");
        List<Receta> recetas = recetaService.findAll();
        logger.debug("Número de recetas encontradas: {}", recetas.size());
        model.addAttribute("recetas", recetas);
        return recetas;
    }

    @GetMapping("/recetas/nueva")
    public String showCreateRecetaForm(Model model) {
        logger.debug("Mostrando formulario de nueva receta");
        model.addAttribute("receta", new Receta());
        return "crear_receta";
    }

    @PostMapping("/recetas/nueva")
    public String createReceta(@ModelAttribute("receta") Receta receta) {
        logger.debug("Creando nueva receta: {}", receta);
        recetaService.save(receta);
        logger.info("Receta creada exitosamente");
        return "redirect:/recetas";
    }
}
