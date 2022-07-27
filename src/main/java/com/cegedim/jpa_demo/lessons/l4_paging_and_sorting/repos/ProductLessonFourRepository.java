package com.cegedim.jpa_demo.lessons.l4_paging_and_sorting.repos;

import com.cegedim.jpa_demo.lessons.l4_paging_and_sorting.entites.ProductLessonFour;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductLessonFourRepository extends PagingAndSortingRepository<ProductLessonFour, Integer> {

	List<ProductLessonFour> findByName(String name);

	List<ProductLessonFour> findByNameAndDesc(String name, String desc);

	List<ProductLessonFour> findByPriceGreaterThan(Double price);

	List<ProductLessonFour> findByDescContains(String desc);

	List<ProductLessonFour> findByPriceBetween(Double price1, Double price2);

	List<ProductLessonFour> findByDescLike(String desc);

	List<ProductLessonFour> findByIdIn(List<Integer> ids,Pageable pageable);

}
