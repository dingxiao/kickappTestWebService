package com.blog.samples.services;

import com.kick.test.webservices.Account4KickInput;;

public interface Account4kick {
	/**
	 * Gets the account details.
	 *
	 * @param accountNumber the account number
	 * @return the account details
	 */
	public String sendAccount4kick(Account4KickInput accountInput);
}
