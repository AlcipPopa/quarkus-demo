package cloud.in.coding.data_access;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    String genre;

    public List<Book> getAllBooks(){
        return List.of(
                new Book(1, "Titolo 1", "Alex", 2024, genre),
                new Book(2, "Titolo 2", "Antonio", 2025, genre),
                new Book(3, "Titolo 3", "Josh", 2026, genre),
                new Book(4, "Titolo 4", "Kenny", 2026, genre)
        );
    }
}
