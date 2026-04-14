package cloud.in.coding;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {
    @Test
    void givenJSONHeader_getBooks_shouldReturnAllBooks() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .when()
            .get("/api/v1/books")
        .then()
            .statusCode(200)
            .body("size()", is(4));
    }

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
            .body("genre", is("IT"));
    }

    @Test
    void givenTextPlainHeaderAndAdminRole_count_shouldReturnNumberOfBooks() {
        given()
            .auth().preemptive().basic("my-user", "my-password")
            .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
        .when()
            .get("/api/v1/books/count")
        .then()
            .statusCode(200)
            .body(is("4"));
    }

    @Test
    void givenWrongRole_count_shouldReturnForbiddenWithCustomBody() {
        given()
            .auth().preemptive().basic("readonly-user", "readonly-password")
        .when()
            .get("/api/v1/books/count")
        .then()
            .statusCode(403)
            .body("status", is(403))
            .body("code", is("Forbidden"))
            .body("message", is("Access denied: missing required role"));
    }

}