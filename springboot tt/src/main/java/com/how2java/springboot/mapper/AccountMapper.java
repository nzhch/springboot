package com.how2java.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.how2java.springboot.pojo.Account;



@Mapper
public interface AccountMapper 
{
	public void add(Account account) ;
	public void delete(String name);
	public Account get(String name);
	public void update(Account account);
	public List<Account> list();

}
