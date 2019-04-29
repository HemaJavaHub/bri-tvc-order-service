package com.demo.productservice.ServiceTests;


import com.demo.productservice.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductForOrderServiceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @Before
    public void setUp() {
        this.productService = new ProductService(productRepository);
    }

    @Test
    public void saveProduct_savesTheProduct() {
        //arrange
        Product product = new Product("blue men cotton shirt", "Men", "Shirts", 10.00, "M", 10);

        //act
        productService.saveProduct(product);

        //assert
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void findProductsByCategory_returnsProductsWithThatCategory() {
        String category = "Men";
        //act
        productService.findByCategory(category);
        //assert
        verify(productRepository, times(1)).findByCategory(category);
    }

}
