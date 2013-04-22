package com.blog.samples.services;


import org.springframework.stereotype.Service;

import com.kick.test.webservices.Account4KickInput;
@Service
public class Account4kickImpl implements Account4kick {

	public String sendAccount4kick(Account4KickInput accountInput) {
		/* hard coded account data - in reality this data would be 
		 * save to a database or back end system of some sort */

		String s = "no name from impl";
		if (accountInput.getPrmotionName() != null && accountInput.getCcn() != 0){
			s = "cnn is " + accountInput.getCcn() + " with name " + accountInput.getPrmotionName();
		}
		return s;
	}

}
