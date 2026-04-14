package cloud.in.coding.infra;

import cloud.in.coding.data_access.Book;
import cloud.in.coding.data_access.BookRepository;
import cloud.in.coding.exceptions.NotFoundException;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Path("/api/v1/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    BookRepository bookRepository;

    @PermitAll
    @GET
    public List<Book> getBooks() {
        return bookRepository.getAllBooks();
    }

    @RolesAllowed("my-custom-role-here")
    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        log.info("Counting all books");
        return getBooks().size();
    }

    @GET
    @Path("/{id}")
    public Book getBook(@PathParam("id") int id) {
        return getBooks().stream().filter(b -> b.getId() == id).findFirst()
                .orElseThrow(() -> new NotFoundException("Book " +  id + " not found"));
    }
}
