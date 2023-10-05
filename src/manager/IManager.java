package manager;

import java.util.List;

public interface IManager<E> {
    void add(E e);
    E edit(String id, E e);
    void remove(String id);
    List<E> getAll();
    List<E> getByAbsoluteName(String name);
    List<E> getByType(String type);
    E getById(String id);
}
