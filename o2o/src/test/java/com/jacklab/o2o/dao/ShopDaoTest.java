package com.jacklab.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jacklab.o2o.BaseTest;
import com.jacklab.o2o.entity.Area;
import com.jacklab.o2o.entity.PersonInfo;
import com.jacklab.o2o.entity.Shop;
import com.jacklab.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{

	@Autowired
	private ShopDao shopDao;
	
	@Test
	public void testInsertShop() {
		Shop shop=new Shop(); 
		PersonInfo owner=new PersonInfo();
		Area area=new Area();
		ShopCategory shopCat=new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(1);
		shopCat.setShopCategoryId(1L);
		
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCat);
		shop.setShopName("Jack's shop");
		shop.setAdvice("just created");
		shop.setCreateTime(new Date(System.currentTimeMillis()));
		shop.setEnableStatus(0);
		shop.setPhone("123456789");
		shop.setPriority(1);
		shop.setShopAddr("world office");
		shop.setShopDesc("world class stuff");
		shop.setShopImg("test");
		
		int effectedNum=shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}
	
	@Test
	public void testUpdateShop() {
		Shop shop=new Shop(); 
		shop.setShopId(1L);
//		PersonInfo owner=new PersonInfo();
//		Area area=new Area();
//		ShopCategory shopCat=new ShopCategory();
//		owner.setUserId(1L);
//		area.setAreaId(1);
//		shopCat.setShopCategoryId(1L);
//		
//		shop.setOwner(owner);
//		shop.setArea(area);
//		shop.setShopCategory(shopCat);
//		shop.setShopName("Jack's shop 2");
//		shop.setAdvice("just created 2");
//		shop.setEnableStatus(0);
//		shop.setPhone("1234567890");
//		shop.setPriority(1);
//		shop.setShopAddr("world office 2");
//		shop.setShopDesc("world class stuff 2");
//		shop.setShopImg("test 2");
		shop.setLastEditTime(new Date(System.currentTimeMillis()));
		
		int effectedNum=shopDao.updateShop(shop);
		assertEquals(1,effectedNum);
	}
}
