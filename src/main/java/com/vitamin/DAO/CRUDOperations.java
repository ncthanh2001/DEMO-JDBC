package com.vitamin.DAO;

import java.util.List;
import java.util.Optional;

public interface CRUDOperations<T> {
    // java generic type
    // Object
    void create(T t);

    // Read
    Optional<T> findById(int id);
    List<T> findAll();

    // Update
    void update(T t);

    // Delete
    void delete(int id);

    Boolean insertMentors(List<T> listMentors);

}
