package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NamedStoredProcedureQuery;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
public class CategoriesController {

    @GetMapping(path="/categories")
    public ResponseEntity<List<Category>> list() {
        List<Category> arrayList = getCategories();
        return new ResponseEntity<>(arrayList, HttpStatus.OK);
    }

    private List<Category> getCategories() {
        List<Category> arrayList= new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            Category category = new Category();
            category.setId(new Long(i+1));
            category.setPermalink("http://home.mercadolibre.com.ar/vehiculos-accesorios/");
            arrayList.add(category);
        }
        return arrayList;
    }

    @GetMapping(path="/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable String id) throws Exception {
        List<Category> categories = this.getCategories();
        Optional<Category> stream = categories.stream()
                .filter(category -> category.getId().toString().equals(id)).findFirst();
        if (stream.isEmpty()) {
            throw new Exception();
        }
        return new ResponseEntity<>(stream.get(), HttpStatus.OK);
    }

    @PostMapping(path="/categories")
    public ResponseEntity<Category> createCategory(@RequestBody String categoryString) throws JSONException {
        JSONObject categoryJson = new JSONObject(categoryString);
        Category category = createFromJSON(categoryJson);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    private Category createFromJSON(JSONObject categoryJson) throws JSONException {
        Category category = new Category();
        category.setId(new Long(this.getCategories().size()));
        category.setNombre(categoryJson.getString("nombre"));
        category.setCodigo(categoryJson.getString("codigo"));
        category.setPermalink(categoryJson.getString("permalink"));
        return category;
    }
}
