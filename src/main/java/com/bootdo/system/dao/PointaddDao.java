package com.bootdo.system.dao;

import com.bootdo.system.domain.PointaddDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 积分累计表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-21 22:04:56
 */
@Mapper
public interface PointaddDao {

	PointaddDO get(Long id);
	
	List<PointaddDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PointaddDO pointadd);
	
	int update(PointaddDO pointadd);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
