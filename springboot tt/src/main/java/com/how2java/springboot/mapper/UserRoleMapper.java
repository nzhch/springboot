package com.how2java.springboot.mapper;

import com.how2java.springboot.pojo.UserRole;
import com.how2java.springboot.pojo.UserRoleExample;
import java.util.List;

public interface UserRoleMapper {
	int deleteByPrimaryKey(Long id);

	int insert(UserRole record);

	int insertSelective(UserRole record);

	List<UserRole> selectByExample(UserRoleExample example);

	UserRole selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(UserRole record);

	int updateByPrimaryKey(UserRole record);
}