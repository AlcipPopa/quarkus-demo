package cloud.in.coding;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Path("/api/v1/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    BookRepository bookRepository;

    @GET
    public List<Book> getBooks() {
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        log.info("Counting all books");
        return getBooks().size();
    }

    @GET
    @Path("/{id}")
    public Optional<Book> getBook(@PathParam("id") int id) {
        return getBooks().stream().filter(b -> b.getId() == id).findFirst();
    }
}
