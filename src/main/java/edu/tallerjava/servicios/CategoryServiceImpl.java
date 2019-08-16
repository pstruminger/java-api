package edu.tallerjava.servicios;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.repositorios.CategoryMELIRepository;
import edu.tallerjava.repositorios.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMELIRepository repo;

    @Override
    public List<Category> findAll() {
        return repo.findAllRest();
    }

    /*
    @Override
    public Category save(Category category) {
        return repo.save(category);
    }
     */

    @Override
    public Category findById(Long id) {
        return repo.findByIdRest(id);
    }



}
