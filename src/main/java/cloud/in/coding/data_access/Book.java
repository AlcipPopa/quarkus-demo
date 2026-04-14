package cloud.in.coding.data_access;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Book {
    private int id;
    private String title;
    private String author;
    private int yearOfPublication;
    private String genre;
}
