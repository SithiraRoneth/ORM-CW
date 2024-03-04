package lk.ijse.Dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class BookDTO {
    private String id;
    private String name;
    private String type;
}
