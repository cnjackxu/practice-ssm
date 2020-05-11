package com.jacklab.o2o.dao;

import com.jacklab.o2o.entity.Shop;

public interface ShopDao {

	/**
	 * insert new shop
	 * 1:success -1:failure
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);
	
	/**
	 * update shop
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
