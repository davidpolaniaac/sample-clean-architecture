package co.com.crud.usecase.crudproduct;

import java.util.ArrayList;

import co.com.crud.model.product.Product;
import co.com.crud.model.product.gateways.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class CrudProductUseCaseTest {

    CrudProductUseCase useCase;
    Product product = Product.builder().name("Matrix").build();

    @Mock
    ProductRepository repository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        useCase = new CrudProductUseCase(repository);
    }

    @Test
    public void getProductTest() {
        when(repository.getAll()).thenReturn(new ArrayList<>());
        Assert.assertNotNull(useCase.getAll());
    }


}
