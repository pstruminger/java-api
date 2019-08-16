package edu.tallerjava.repositorios;

import edu.tallerjava.modelo.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CategoryMELIRepository {

    List<Category> findAllRest();
    Category findByIdRest(Long id);
}
