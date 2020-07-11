package com.how2java.springboot.mapper;

import com.how2java.springboot.pojo.Permission;
import com.how2java.springboot.pojo.PermissionExample;
import java.util.List;

public interface PermissionMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Permission record);

	int insertSelective(Permission record);

	List<Permission> selectByExample(PermissionExample example);

	Permission selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);
}