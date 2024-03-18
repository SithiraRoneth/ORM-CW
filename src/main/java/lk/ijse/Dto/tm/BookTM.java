package lk.ijse.Dto.tm;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookTM {
    private String id;
    private String name;
    private String genre;
    private String author;
    private String status;

    public BookTM(String id,String name,String genre,String author,String status){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.status = status;
    }
}
