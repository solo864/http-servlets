package service;

import dao.PublisherDao;
import entity.PublisherEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PublisherService {

    private static final PublisherService INSTANCE = new PublisherService();

    private final PublisherDao publisherDao = PublisherDao.getInstance();


    public List<PublisherEntity> findAll() {
        return publisherDao.findAll();
    }


    public static PublisherService getInstance() {
        return INSTANCE;
    }

}
