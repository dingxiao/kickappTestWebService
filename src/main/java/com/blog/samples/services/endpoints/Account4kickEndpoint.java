
package com.blog.samples.services.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.kick.test.webservices.accountservice.Account4KickRequest;
import com.kick.test.webservices.accountservice.Account4KickResponse;


/**
 * The Class AccountService.
 */
@Endpoint
public class Account4kickEndpoint
{
	private static final String TARGET_NAMESPACE = "http://com/kick/test/webservices/accountservice";

	//@Autowired
	//private AccountService accountService_i;

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
		//Account account = accountService_i.getAccountDetails(request.getAccountNumber());
		if (request.getKickInfo() != null && request.getKickInfo().getName() != null){
			response.setKickStatus(request.getKickInfo().getName());
		}
		else
			response.setKickStatus("no name");
		return response;
	}

}