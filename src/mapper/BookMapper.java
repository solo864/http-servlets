package mapper;


import dto.BookRegisterDto;
import entity.BookEntity;

public class BookMapper {

    public static BookEntity mapDtoToEntity(BookRegisterDto dto) {
        return BookEntity.builder()
                .name(dto.getName())
                .genre(dto.getGenre())
                .pageCount(dto.getPageCount())
                .publishingYear(dto.getPublishingYear())
                .build();
    }
}
