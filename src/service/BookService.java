package service;

import dao.BookDao;
import dto.BookRegisterDto;
import entity.BookEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import mapper.BookMapper;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookService {


    private static final BookService INSTANCE = new BookService();

    private final BookDao bookDao = BookDao.getInstance();


    public BookEntity save(BookRegisterDto bookRegisterDto) {
        BookEntity entity = BookMapper.mapDtoToEntity(bookRegisterDto);
        return bookDao.save(entity);
    }

    public List<BookEntity> findAllByPublisherId(Long publisherId) {
        return bookDao.findByPublisherId(publisherId);
    }


    public static BookService getInstance() {
        return INSTANCE;
    }

}
