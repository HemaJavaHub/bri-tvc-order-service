package com.demo.productservice.RepositoryTests;

import com.demo.productservice.TestUtils.TestProducts;
import com.demo.productservice.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void repoSavesInDB() throws Exception {
        Product product = TestProducts.getProducts().get(0);

        Integer id = testEntityManager.persistAndGetId(product, Integer.class);
        Product foundProduct = productRepository.findById(id).orElse(null);
        assertThat(foundProduct.getCategory()).isEqualTo(product.getCategory());
    }

    /*@Test
    public void findSongByName_returnsSongsWithThatName(){
        String category="Men";

        int size = productRepository.findByCategory(category).size();
        assertThat(size==3);

    }*/
}