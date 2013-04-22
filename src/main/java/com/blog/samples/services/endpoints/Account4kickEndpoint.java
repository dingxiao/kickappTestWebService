
package com.blog.samples.services.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.blog.samples.services.Account4kick;
import com.kick.test.webservices.accountservice.Account4KickRequest;
import com.kick.test.webservices.accountservice.Account4KickResponse;


/**
 * The Class AccountService.
 */
@Endpoint
public class Account4kickEndpoint
{
	private static final String TARGET_NAMESPACE = "http://com/kick/test/webservices/accountservice";

	//
	//auto not work because Account4kickImpl does not have @Service, which will create bean
	//after add @service to Account4kickImpl, with base-package="com.blog.samples.services" in config, spring will aoto detect and create bean
	@Autowired
	private Account4kick account4kick_i;

	/**
	 * Gets the account details.
	 *
	 * @param accountNumber the account number
	 * @return the account details
	 */

	@PayloadRoot(localPart = "Account4kickRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload Account4KickResponse getAccount4kick(@RequestPayload Account4KickRequest request)
	{
		Account4KickResponse response = new Account4KickResponse();

		/* call Spring injected service implementation to retrieve account data */
		if (request.getSetPromotionValues() != null){
			String st = account4kick_i.sendAccount4kick(request.getSetPromotionValues());
			response.setKickStatus(st);//(request.getKickInfo().getName());
		}
		else
			response.setKickStatus("input has no info obj");
		return response;
	}
	public void setAccount4kick(Account4kick account4kick_p)
	{
		this.account4kick_i = account4kick_p;
	}

}