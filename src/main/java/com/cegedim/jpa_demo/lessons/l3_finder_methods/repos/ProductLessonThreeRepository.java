package com.cegedim.jpa_demo.lessons.l3_finder_methods.repos;

import com.cegedim.jpa_demo.lessons.l3_finder_methods.entites.ProductLessonThree;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductLessonThreeRepository extends CrudRepository<ProductLessonThree, Integer> {

	List<ProductLessonThree> findByName(String name);

	List<ProductLessonThree> findByNameAndDesc(String name, String desc);

	List<ProductLessonThree> findByPriceGreaterThan(Double price);

	List<ProductLessonThree> findByDescContains(String desc);

	List<ProductLessonThree> findByPriceBetween(Double price1, Double price2);

	List<ProductLessonThree> findByDescLike(String desc);

	List<ProductLessonThree> findByIdIn(List<Integer> ids,Pageable pageable);

}
