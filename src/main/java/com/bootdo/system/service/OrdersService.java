package com.bootdo.system.service;

import com.bootdo.system.domain.OrdersDO;

import java.util.List;
import java.util.Map;

/**
 * 订单表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-21 22:04:56
 */
public interface OrdersService {
	
	OrdersDO get(Integer id);
	
	List<OrdersDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrdersDO orders);
	
	int update(OrdersDO orders);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
