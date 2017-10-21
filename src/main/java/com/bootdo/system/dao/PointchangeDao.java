package com.bootdo.system.dao;

import com.bootdo.system.domain.PointchangeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 积分换取记录表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-21 22:04:56
 */
@Mapper
public interface PointchangeDao {

	PointchangeDO get(Long id);
	
	List<PointchangeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PointchangeDO pointchange);
	
	int update(PointchangeDO pointchange);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
