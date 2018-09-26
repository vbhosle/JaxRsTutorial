package com.viraj.javabrains.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.viraj.javabrains.messenger.model.Comment;
import com.viraj.javabrains.messenger.model.Message;
import com.viraj.javabrains.messenger.model.Profile;

public class DatabaseClass {
	
	private static long messageSequence = 1L;
	private static long profileSequence = 1L;
	private static long commentSequence = 1L;
	
	private static Map<Long,Message> messages = new HashMap<>();	
	private static Map<Long,Comment> comments = new HashMap<>();	
	private static Map<String,Profile> profiles = new HashMap<>();	
	
	static {
		Long id = getNextMessageSequence();
		messages.put(id, new Message(id, "Hello World!", "vbhosle"));
		id = getNextMessageSequence();
		messages.put(id,new Message(id, "Hello Jersey!", "vbhosle"));
		
		id = getNextCommentSequence();
		comments.put(id, new Comment(id, "superb", "vbhosle"));
		id = getNextCommentSequence();
		comments.put(id, new Comment(id, "great", "vbhosle"));
		
		messages.get(1L).setComments(comments);
		
		id = getNextProfileSequence();
		profiles.put("vbhosle", new Profile(id, "vbhosle", "Viraj", "Bhosle"));
		id = getNextProfileSequence();
		profiles.put("karenb", new Profile(id, "karenb", "Karen", "Baker"));
	}
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
	public static Long getNextMessageSequence() {
		return messageSequence++;
	}
	
	public static Long getNextProfileSequence() {
		return profileSequence++;
	}
	
	public static Long getNextCommentSequence() {
		return commentSequence++;
	}
}
