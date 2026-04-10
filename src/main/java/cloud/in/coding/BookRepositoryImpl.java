package cloud.in.coding;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

    public List<Book> getAllBooks(){
        return List.of(
                new Book(1, "Titolo 1", "Alex", 2024, "IT"),
                new Book(2, "Titolo 2", "Antonio", 2025, "IT"),
                new Book(3, "Titolo 3", "Josh", 2026, "IT"),
                new Book(4, "Titolo 4", "Kenny", 2026, "IT")
        );
    }
}
