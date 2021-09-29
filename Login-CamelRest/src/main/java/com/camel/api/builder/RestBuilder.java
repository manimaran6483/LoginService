package com.camel.api.builder;

import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.camel.api.processor.UserProcessor;
import com.camel.api.request.UserRequest;
import com.camel.api.response.UserResponse;

@Component
public class RestBuilder extends RouteBuilder {

	
	@BeanInject
	private UserProcessor userProcessor;

	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").port(9090).enableCORS(true) // <-- Important
        .corsAllowCredentials(true) // <-- Important
        .host("localhost").bindingMode(RestBindingMode.json);
		
		//rest().post("/api").consumes(MediaType.APPLICATION_JSON_VALUE).type(User.class)
			//	.to("bean:userService?method=validateUser()");
		
		rest().post("/api").consumes(MediaType.APPLICATION_JSON_VALUE).type(UserRequest.class).outType(UserResponse.class)
				.route().process(userProcessor).endRest();
		}
}
