package co.com.crud.api;
import co.com.crud.model.product.Product;
import co.com.crud.usecase.crudproduct.CrudProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final CrudProductUseCase crudProductUseCase;

    @PostMapping(path = "/product")
    public void create(@RequestBody Product product){
        crudProductUseCase.create(product);
    }

    @GetMapping(path = "/product/{id}")
    public Product read(@PathVariable String id) {
        return crudProductUseCase.read(id);
    }

    @PutMapping(path = "/product/{id}")
    public void update(@PathVariable String id, @RequestBody  Product product) {
        try {
            crudProductUseCase.update(id, product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @DeleteMapping(path = "/product/{id}")
    public void delete(@PathVariable String id){
        crudProductUseCase.delete(id);
    }

    @GetMapping(path = "/product")
    public List<Product> getAll(){
        return crudProductUseCase.getAll();
    }
}
