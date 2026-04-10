package cloud.in.coding;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Book {
    private int id;
    private String title;
    private String author;
    private int yearOfPublication;
    private String genre;
}
