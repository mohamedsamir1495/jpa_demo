package com.cegedim.jpa_demo.lessons.l3_finder_methods;

import com.cegedim.jpa_demo.lessons.l3_finder_methods.entites.ProductLessonThree;
import com.cegedim.jpa_demo.lessons.l3_finder_methods.repos.ProductLessonThreeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class L3FinderMethodsTests {

	@Autowired
	ProductLessonThreeRepository repository;

	@Test
	public void testCreate() {
		ProductLessonThree product = new ProductLessonThree();
		product.setId(1);
		product.setName("IWatch");
		product.setDesc("From Apple Inc");
		product.setPrice(400d);

		ProductLessonThree product2 = new ProductLessonThree();
		product2.setId(2);
		product2.setName("Tv");
		product2.setDesc("From Samsung Inc");
		product2.setPrice(1000d);

		ProductLessonThree product3 = new ProductLessonThree();
		product3.setId(3);
		product3.setName("Washer");
		product3.setDesc("From LG Inc");
		product3.setPrice(2000d);

		ProductLessonThree product4 = new ProductLessonThree();
		product4.setId(4);
		product4.setName("Dryer");
		product4.setDesc("From LG Inc");
		product4.setPrice(1500d);

		repository.saveAll(Arrays.asList(product, product2, product3, product4));
	}

	@Test
	public void testRead() {
		ProductLessonThree product = repository.findById(1).get();
		assertNotNull(product);
		assertEquals("Iphone", product.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + product.getDesc());
	}

	@Test
	public void testUpdate() {
		ProductLessonThree product = repository.findById(1).get();
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
		List<ProductLessonThree> products = repository.findByName("IWatch");
		products.forEach(p -> System.out.println(p.getPrice()));

		List<ProductLessonThree> products1 = repository.findByName("IWatch");
		products1.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByNameAndDesc() {
		List<ProductLessonThree> products = repository.findByNameAndDesc("TV", "From Samsung Inc");
		products.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByPriceGreaterThan() {
		List<ProductLessonThree> products = repository.findByPriceGreaterThan(1000d);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescContains() {
		List<ProductLessonThree> products = repository.findByDescContains("Apple");
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByPriceBetween() {
		List<ProductLessonThree> products = repository.findByPriceBetween(500d, 2500d);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescLike() {
		List<ProductLessonThree> products = repository.findByDescLike("%LG%");
		products.forEach(p -> System.out.println(p.getName()));
	}

}
