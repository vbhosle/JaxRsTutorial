package com.viraj.javabrains.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.viraj.javabrains.messenger.exception.DataNotFoundException;
import com.viraj.javabrains.messenger.model.Message;
import com.viraj.javabrains.messenger.resources.bean.MessageFilterBean;
import com.viraj.javabrains.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	private MessageService messageService = new MessageService(); 
	//private CommentsResource commentsResource = new CommentsResource();

//	@GET
//	public List<Message> getMessages(
//										@QueryParam("year") int year,
//										@QueryParam("start") int start,
//										@QueryParam("size") int size
//									)
//	{
//		if(year>0) {
//			return messageService.getAllMessagesForYear(year);
//		}
//		
//		if(start>=0 && size>0) {
//			return messageService.getAllMessagesPaginated(start, size);
//		}
//		return messageService.getAllMessages();
//	}

	@GET
	public List<Message> getMessages(
										@BeanParam MessageFilterBean filterBean
									)
	{
		if(filterBean.getYear()>0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		
		if(filterBean.getStart()>=0 && filterBean.getSize()>0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")Long id) {
		Message message = messageService.getMessage(id);
		if(message == null) {
			throw new DataNotFoundException("Message with id " + id + " not found!" );
		}
		return messageService.getMessage(id);
	}
	
//	@POST
//	public Message addMessage(Message message) {
//		return messageService.addMessage(message);
//	}
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message newMessage = messageService.addMessage(message);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
//		return Response.created(new URI("/messenger/webapi/messages/"+ newMessage.getId()))
//				.entity(newMessage)
//				.cookie(new NewCookie("lastAddedMessageID", ""+newMessage.getId()))
//				.build();
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")Long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void addMessage(@PathParam("messageId")Long id) {
		messageService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentsResource getCommentsResource() {
		return new CommentsResource();
	}
}
