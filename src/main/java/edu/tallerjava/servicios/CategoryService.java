package edu.tallerjava.servicios;

import edu.tallerjava.modelo.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();
    //Category save(Category category);
    Category findById(Long id);

}
