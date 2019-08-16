package edu.tallerjava.repositorios;

import edu.tallerjava.modelo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryMeliRepositoryImpl implements CategoryMELIRepository {

    protected TestRestTemplate restTemplate = new TestRestTemplate();

    @Override
    public List<Category> findAllRest() {
        final List results = restTemplate.getForObject("https://api.mercadolibre.com/sites/MLA/categories/", List.class);
        return results;
    }

    @Override
    public Category findByIdRest(Long id) {
        //final List<Category> categories = restTemplate.exchange("api.mercadolibre.com/sites/MLA/categories", HttpMethod.GET, null, new ParameterizedTypeReference<List>(){}).getBody();
        String uri = "api.mercadolibre.com/categories/" + id.toString();

        final ResponseEntity<Category> responseEntity = restTemplate.getForEntity(uri, Category.class);
        return responseEntity.getBody();
    }
}
