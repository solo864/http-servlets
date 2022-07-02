package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity {


    private Long id;
    private String name;
    private String genre;
    private Integer pageCount;
    private Integer publishingYear;

}
