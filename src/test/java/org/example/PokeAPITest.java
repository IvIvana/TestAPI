package org.example;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PokeAPITest {

    @Test
    public void testValidBerryEndpointById() {

        baseURI = "https://pokeapi.co/api/v2";

        String berryId = "1";

        // Send GET request to the berry endpoint with the valid ID and validate response
        given()
                .pathParam("id", berryId)
                .when()
                .get("/berry/{id}")
                .then()
                .statusCode(200) // Check if response status code is 200 (OK)
                .body("name", equalTo("cheri")); // Check if response body contains expected name of the berry
    }

    @Test
    public void testInvalidBerryEndpointById() {

        baseURI = "https://pokeapi.co/api/v2";

        // Define an invalid berry ID
        String invalidBerryId = "999999";

        // Send GET request to the berry endpoint with the invalid ID and validate response
        given()
                .pathParam("id", invalidBerryId)
                .when()
                .get("/berry/{id}")
                .then()
                .statusCode(404); // Check if response status code is 404 (Not Found)
    }

    @Test
    public void testValidBerryEndpointByName() {

        baseURI = "https://pokeapi.co/api/v2";

        // Define a valid berry name
        String berryName = "cheri";

        // Send GET request to the berry endpoint with the valid name and validate response
        given()
                .pathParam("name", berryName)
                .when()
                .get("/berry/{name}")
                .then()
                .statusCode(200) // Check if response status code is 200 (OK)
                .body("name", equalTo("cheri")); // Check if response body contains expected name of the berry
    }

    @Test
    public void testInvalidBerryEndpointByName() {

        baseURI = "https://pokeapi.co/api/v2";

        // Define an invalid berry name
        String invalidBerryName = "invalid_berry";

        // Send GET request to the berry endpoint with the invalid name and validate response
        given()
                .pathParam("name", invalidBerryName)
                .when()
                .get("/berry/{name}")
                .then()
                .statusCode(404); // Check if response status code is 404 (Not Found)
    }
    @Test
    public void testValidBerryFlavorEndpointByName() {

        baseURI = "https://pokeapi.co/api/v2";

        // Define a valid berry flavor name
        String berryFlavorName = "spicy";

        // Send GET request to the berry flavor endpoint with the valid name and validate response
        given()
                .pathParam("name", berryFlavorName)
                .when()
                .get("/berry-flavor/{name}/")
                .then()
                .statusCode(200) // Check if response status code is 200 (OK)
                .body("name", equalTo("spicy")); // Check if response body contains expected name of the berry flavor
    }
}
