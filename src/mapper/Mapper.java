package mapper;

public interface Mapper<T, F> {

    T MapCreateDtoToEntity(F object);


}
