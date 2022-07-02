package mapper;

public interface Mapper<T, F> {

    T mapTo(F object);


}
