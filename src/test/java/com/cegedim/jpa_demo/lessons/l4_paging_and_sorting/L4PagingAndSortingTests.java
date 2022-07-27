package com.cegedim.jpa_demo.lessons.l4_paging_and_sorting;

import com.cegedim.jpa_demo.lessons.l4_paging_and_sorting.entites.ProductLessonFour;
import com.cegedim.jpa_demo.lessons.l4_paging_and_sorting.repos.ProductLessonFourRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class L4PagingAndSortingTests {

	@Autowired
	ProductLessonFourRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		ProductLessonFour product = new ProductLessonFour();
		product.setId(1);
		product.setName("IWatch");
		product.setDesc("From Apple Inc");
		product.setPrice(400d);

		ProductLessonFour product2 = new ProductLessonFour();
		product2.setId(2);
		product2.setName("Tv");
		product2.setDesc("From Samsung Inc");
		product2.setPrice(1000d);

		ProductLessonFour product3 = new ProductLessonFour();
		product3.setId(3);
		product3.setName("Washer");
		product3.setDesc("From LG Inc");
		product3.setPrice(2000d);

		ProductLessonFour product4 = new ProductLessonFour();
		product4.setId(4);
		product4.setName("Dryer");
		product4.setDesc("From LG Inc");
		product4.setPrice(1500d);

		repository.saveAll(Arrays.asList(product, product2, product3, product4));
	}

	@Test
	public void testRead() {
		ProductLessonFour product = repository.findById(1).get();
		assertNotNull(product);
		assertEquals("Iphone", product.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + product.getDesc());
	}

	@Test
	public void testUpdate() {
		ProductLessonFour product = repository.findById(1).get();
		product.setPrice(1200d);
		repository.save(product);

	}

	@Test
	public void testDelete() {
		if (repository.existsById(1)) {
			System.out.println("Deleting a product");
			repository.deleteById(1);
		}
	}

	@Test
	public void testCount() {
		System.out.println("Total Records===============>>>>>>>>>>>>>>>" + repository.count());

	}

	@Test
	public void testFindByName() {
		List<ProductLessonFour> products = repository.findByName("IWatch");
		products.forEach(p -> System.out.println(p.getPrice()));

		List<ProductLessonFour> products1 = repository.findByName("IWatch");
		products1.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByNameAndDesc() {
		List<ProductLessonFour> products = repository.findByNameAndDesc("TV", "From Samsung Inc");
		products.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByPriceGreaterThan() {
		List<ProductLessonFour> products = repository.findByPriceGreaterThan(1000d);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescContains() {
		List<ProductLessonFour> products = repository.findByDescContains("Apple");
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByPriceBetween() {
		List<ProductLessonFour> products = repository.findByPriceBetween(500d, 2500d);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescLike() {
		List<ProductLessonFour> products = repository.findByDescLike("%LG%");
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByIdsIn() {
		Pageable pageable = PageRequest.of(0, 2);
		List<ProductLessonFour> products = repository.findByIdIn(Arrays.asList(1, 2, 3), pageable);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllPaging() {
		Pageable pageable = PageRequest.of(0, 2);
		Iterable<ProductLessonFour> results = repository.findAll(pageable);
		results.forEach(p -> System.out.println(p.getName()));

	}

	@Test
	public void testFindAllSorting() {
		repository.findAll(Sort.by(new Sort.Order(Direction.DESC, "name"), new Sort.Order(null, "price")))
				  .forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

		repository.findAll(Sort.by("name", "price")).forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));
		repository.findAll(Sort.by(Direction.ASC, "name", "price")).forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

	}

	@Test
	public void testFindAllPagingAndSorting() {
		Pageable pageable = PageRequest.of(0, 2, Sort.by(new Sort.Order(Direction.DESC, "name"), new Sort.Order(null, "price")));
		repository.findAll(pageable).forEach(p -> System.out.println(p.getName()));

	}

}
