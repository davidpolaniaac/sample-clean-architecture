package co.com.crud.jpa;

import co.com.crud.jpa.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepository extends CrudRepository<ProductEntity, String>, QueryByExampleExecutor<ProductEntity> {
}
