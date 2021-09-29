package com.camel.api.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.camel.api.request.UserRequest;
import com.camel.api.response.UserResponse;
import com.camel.api.service.UserService;

@Component
public class UserProcessor implements Processor{

	@Autowired
	private UserService userService;
	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("processor called");
		//System.out.println(exchange.getIn().getBody());
		UserResponse response = userService.validateUser(exchange.getIn().getBody(UserRequest.class));
		exchange.getIn().setBody(response);
		
	}

}
