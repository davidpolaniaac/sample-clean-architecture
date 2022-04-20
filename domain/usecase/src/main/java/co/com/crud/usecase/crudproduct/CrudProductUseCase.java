package co.com.crud.usecase.crudproduct;

import java.util.List;

import co.com.crud.model.product.Product;
import co.com.crud.model.product.gateways.ProductRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CrudProductUseCase {

    private ProductRepository productRepository;

    public void create(Product product){
        productRepository.create(product);
    }
    public Product read(String id){
        return productRepository.read(id);
    }
    public void update(String id, Product product) throws Exception{
        productRepository.update(id, product);
    }
    public void delete(String id){
        productRepository.delete(id);
    }
    public List<Product> getAll(){
        return productRepository.getAll();
    }
}
