package com.how2java.springboot.service;
import java.sql.Date;

import org.apache.poi.ss.usermodel.DataConsolidateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.springboot.mapper.AccountMapper;
import com.how2java.springboot.pojo.Account;
@Service
public class AccountService {
	@Autowired AccountMapper accountMapper;
	public void add(Account account)
	{
		accountMapper.add(account);
		
	}
	public Date getStartimeDate(Account account)
	{
		Account account2=accountMapper.get(account.getName());
		return account2.getStarttime();
	}
	public Date getEndtimeDate(Account account)
	{
		Account account3=accountMapper.get(account.getName());
		return account3.getEndtime();
	}
	public void changepassword(Account account)
	{
		accountMapper.update(account);
	}
	public boolean outtime(Account account)
	{
		Date currentDate = new Date(System.currentTimeMillis());
		Account account2=accountMapper.get(account.getName());
		return currentDate.after(account2.getEndtime());

	}
	public boolean isadmin(Account account)
	{
		Account account2=accountMapper.get(account.getName());
		return account2.isAdmin();
	}
}
