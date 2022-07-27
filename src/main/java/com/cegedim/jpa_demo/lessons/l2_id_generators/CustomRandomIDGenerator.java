package com.cegedim.jpa_demo.lessons.l2_id_generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomRandomIDGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor si, Object obj) throws HibernateException {
		Random random = null;
		int id = 0;
		random = new Random();
		id = random.nextInt(1000000);
		return (long) id;
	}

}
