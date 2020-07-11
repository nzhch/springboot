package com.how2java.springboot.mapper;

import com.how2java.springboot.pojo.RolePermission;
import com.how2java.springboot.pojo.RolePermissionExample;
import java.util.List;

public interface RolePermissionMapper {
	int deleteByPrimaryKey(Long id);

	int insert(RolePermission record);

	int insertSelective(RolePermission record);

	List<RolePermission> selectByExample(RolePermissionExample example);

	RolePermission selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(RolePermission record);

	int updateByPrimaryKey(RolePermission record);
}