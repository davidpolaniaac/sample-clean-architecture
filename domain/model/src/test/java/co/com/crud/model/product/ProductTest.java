package co.com.crud.model.product;

import co.com.crud.model.product.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {

    Product product;

    @Before
    public void init() {
        product = Product.builder().id("1").name("apple").build();
    }

    @Test
    public void categoryTest() {
        Assert.assertEquals("apple", product.getName());
    }

}
