package cloud.in.coding;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
class BookResourceIT extends BookResourceTest {
    // Execute the same tests but in packaged mode.

    @Override
    @Test
    void givenID1_getBook_shouldReturnBookNumber1() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
                .when()
                .get("/api/v1/books/{id}")
                .then()
                .statusCode(200)
                .body("title", is("Titolo 1"))
                .body("author", is("Alex"))
                .body("yearOfPublication", is(2024))
                .body("genre", is("Horror"));
    }
}
