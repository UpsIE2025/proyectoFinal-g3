package ups.edu.ec.micromariaDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.micromariaDB.model.Auto;
import ups.edu.ec.micromariaDB.repository.AutoRepository;
import ups.edu.ec.micromariaDB.service.AutoService;

@RestController
@RequestMapping("/autos")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @Autowired
    private AutoRepository autoRepository;

    @PostMapping
    public Auto createAuto(@RequestBody Auto auto) {
        return autoService.save(auto);  // Usamos el método save para guardar el auto
    }

    @GetMapping("/listaAutos")
    public Iterable<Auto> getAllAutos() {
        return autoRepository.findAll();  // Obtenemos todos los autos
    }
}
