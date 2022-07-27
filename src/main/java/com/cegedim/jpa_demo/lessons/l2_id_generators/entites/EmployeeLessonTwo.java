package com.cegedim.jpa_demo.lessons.l2_id_generators.entites;

import javax.persistence.*;

@Entity
@Table(name = "employee_lesson_2")
public class EmployeeLessonTwo {

	@Id
	//	@GeneratedValue(generator = "emp_id")
	//	@GeneratedValue(strategy = GenerationType.AUTO)
	//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//	@GenericGenerator(name = "emp_id", strategy = "com.cegedim.jpa_demo.lessons.l2_id_generators.CustomRandomIDGenerator")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
	@TableGenerator(name = "employee_gen", table = "id_generator_lesson_2", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 150)
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
