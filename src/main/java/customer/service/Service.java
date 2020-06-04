package customer.service;

import java.util.List;

public interface Service<T> {
    public List<T> findAll();

    public T findById(Long id);

    public void save(T model);

    public void remove(Long id);
}
