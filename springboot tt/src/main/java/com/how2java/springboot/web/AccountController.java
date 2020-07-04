package com.how2java.springboot.web;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.how2java.springboot.pojo.Account;
import com.how2java.springboot.service.AccountService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
@RestController
public class AccountController {
	@Autowired AccountService accountService;	
	@PostMapping("/sign_up")
	public void sign_up(HttpServletRequest httpServletRequest )
	{
		Account account=new Account();
		account.setName(httpServletRequest.getParameter("name"));
		account.setPassword(httpServletRequest.getParameter("password"));
		account.setAdmin(false);
		account.setStarttime(new Date(System.currentTimeMillis()));
		account.setEndtime(new Date(System.currentTimeMillis()));
		accountService.add(account);
	}
	@PostMapping("/sign_in")
	public void sign_in(HttpServletRequest httpServletRequest )
	{
		
	}
	
}
