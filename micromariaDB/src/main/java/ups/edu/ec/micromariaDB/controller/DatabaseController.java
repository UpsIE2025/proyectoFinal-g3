package ups.edu.ec.micromariaDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ups.edu.ec.micromariaDB.model.MyEntity;
import ups.edu.ec.micromariaDB.repository.MyEntityRepository;

@RestController
public class DatabaseController {

    @Autowired
    private MyEntityRepository repository;

    @GetMapping("/entities")
    public Iterable<MyEntity> getAllEntities() {
        return repository.findAll();
    }
}