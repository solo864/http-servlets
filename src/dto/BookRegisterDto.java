package dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookRegisterDto {

    private String name;
    private String genre;
    private Integer pageCount;
    private Integer publishingYear;

}
