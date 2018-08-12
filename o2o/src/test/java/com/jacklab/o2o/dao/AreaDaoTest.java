package com.jacklab.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jacklab.o2o.BaseTest;
import com.jacklab.o2o.entity.Area;

public class AreaDaoTest extends BaseTest{

	@Autowired
	private AreaDao areaDao;
	
	@Test
	public void testQueryArea() {
		List<Area> list = areaDao.queryArea();
		System.out.println(">>>>>>>>>> "+list.get(0).toString());
		assertEquals(2, list.size());
	}
}
