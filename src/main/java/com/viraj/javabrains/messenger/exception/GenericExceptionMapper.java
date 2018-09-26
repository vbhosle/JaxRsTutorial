package com.viraj.javabrains.messenger.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.viraj.javabrains.messenger.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		System.out.println(exception.getMessage());
		ErrorMessage message = new ErrorMessage(exception.getMessage(), 500, "");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				 	.type(MediaType.APPLICATION_JSON)
					.entity(message)
					.build();
	}

}
