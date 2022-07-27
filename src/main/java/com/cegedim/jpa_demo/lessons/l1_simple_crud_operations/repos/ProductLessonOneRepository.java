package com.cegedim.jpa_demo.lessons.l1_simple_crud_operations.repos;

import com.cegedim.jpa_demo.lessons.l1_simple_crud_operations.entites.ProductLessonOne;
import org.springframework.data.repository.CrudRepository;

public interface ProductLessonOneRepository extends CrudRepository<ProductLessonOne, Integer> {

}
