package com.o2o.action.server.repo;

import com.o2o.action.server.db.Category;
import com.o2o.action.server.db.Category.Type;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findByParentOrderByDispOrderAsc(Category parent);
    List<Category> findByKeycodeOrderByDispOrderAsc(String keycode);
    List<Category> findByKeycodeInOrderByDispOrderAsc(List<String> keycords);
    List<Category> findByTitleContainingAndCatType(String keyword, Type type);
}
