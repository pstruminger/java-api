package edu.tallerjava.controladores;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.tallerjava.modelo.Category;
import edu.tallerjava.servicios.CategoryService;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriesController {

    @Autowired
    private CategoryService service;

    @GetMapping(path="/categories")
    public ResponseEntity<List<Category>> list() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path="/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable String id) {
        try {
            return new ResponseEntity<>(service.findById(Long.parseLong(id)), HttpStatus.OK);
        }
        catch (NullPointerException npe) {
            return new ResponseEntity<>((Category) null, HttpStatus.OK);
        }
    }

    /*
    @PostMapping(path="/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        //return new ResponseEntity<>(category, HttpStatus.OK);   //no hace falta parsear ningún JSON porque Spring lo hace solo
        return new ResponseEntity<>(service.save(category), HttpStatus.OK);
    }
    */



}
