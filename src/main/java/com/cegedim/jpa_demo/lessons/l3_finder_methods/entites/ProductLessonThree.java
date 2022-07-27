package com.cegedim.jpa_demo.lessons.l3_finder_methods.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "product_lesson_3")
public class ProductLessonThree implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	@Column(name = "description")
	private String desc;
	private Double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}