package io.quarkus.it.panache;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class HibernateProxyFieldAccessTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/folder")
                .then()
                .statusCode(200)
                .body(is("name: it is working!"));
    }
}
