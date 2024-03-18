/* Created By Sithira Roneth
 * Date :2/29/24
 * Time :22:04
 * Project Name :ORM
 * */
package lk.ijse.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    @Id
    @Column(name = "book_id",length = 5)
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "genre")
    private String genre;
    @Column(name = "author")
    private String author;
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =  "bookList")
    private List<Transactions> transactions = new ArrayList<>();

    public Book(String id,String title,String genre,String author){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }
    public Book(String id,String title,String genre,String author,String status){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.status = status;
    }
}