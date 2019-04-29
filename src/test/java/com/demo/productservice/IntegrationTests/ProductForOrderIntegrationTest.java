package com.demo.productservice.IntegrationTests;


import com.demo.productservice.TestUtils.TestProducts;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ProductForOrderIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void postingProduct_savesTheProduct() throws JsonProcessingException {
        //act
        ResponseEntity<String> response = restTemplate.postForEntity("/products", TestProducts.getProducts().get(1),String.class);

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("saved");
    }

    @Test
    public void searchForProductByCategory_returnsProductsWithMatchingCategory() throws Exception {
        //arrange
        restTemplate.postForEntity("/products", TestProducts.getProducts().get(0),String.class);

        //act
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/products/Men", Product[].class);

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        for (Product product : response.getBody()) {
            assertThat(product.getCategory()).contains("Men");
        }
    }
}
