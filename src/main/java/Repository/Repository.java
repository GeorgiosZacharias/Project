package Repository;
import java.util.List;
public interface Repository<T> {
    T getObject(int index);
    void remove(T t);
}
