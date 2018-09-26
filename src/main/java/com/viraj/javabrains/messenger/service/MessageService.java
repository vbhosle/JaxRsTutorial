package com.viraj.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;


import com.viraj.javabrains.messenger.database.DatabaseClass;
import com.viraj.javabrains.messenger.model.Message;

public class MessageService {
	
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message: messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if((start+size)>list.size()) return new ArrayList<Message>();
		return list.subList(start, start+size);
	}

	
	public Message getMessage(Long id) {	
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(DatabaseClass.getNextMessageSequence());
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0) return null;
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(Long id) {
		return messages.remove(id);
	}
	
	

}
