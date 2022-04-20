package co.com.crud.jpa;

import co.com.crud.model.product.Product;
import co.com.crud.model.product.gateways.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class JpaProductImp implements ProductRepository {

    private JPARepositoryAdapter jpaRepositoryAdapter;
    @Override
    public void create(Product product) {
        String id = UUID.randomUUID().toString();
        product.setId(id);
        jpaRepositoryAdapter.save(product);
    }

    @Override
    public Product read(String id) {
        return jpaRepositoryAdapter.findById(id);
    }

    @Override
    public void update(String id, Product product) throws Exception {
        Product productDb = jpaRepositoryAdapter.findById(id);
        if (productDb == null) {
            throw new Exception("No Product found " + id);
        }
        product.setId(productDb.getId());
        jpaRepositoryAdapter.save(product);
    }

    @Override
    public void delete(String id) {
        Product productDb = jpaRepositoryAdapter.findById(id);
        if (productDb != null) {
            jpaRepositoryAdapter.delete(productDb);
        }
    }

    @Override
    public List<Product> getAll() {
        return jpaRepositoryAdapter.findAll();
    }
}
