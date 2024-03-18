package lk.ijse.Dto;

import lombok.*;

@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class BookDTO {
    private String id;
    private String title;
    private String genre;
    private String author;
    private String status;
    public BookDTO(String id,String title,String genre,String author,String status) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.status = status;
    }
    public BookDTO(String id,String title,String genre,String author) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }
}
