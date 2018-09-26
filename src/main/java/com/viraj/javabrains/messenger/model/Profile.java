package com.viraj.javabrains.messenger.model;

import java.time.LocalDateTime;

public class Profile {

	private long id;
	private String profileName;
	private String firstName;
	private String lastName;
	private LocalDateTime created;
	
	public Profile() {}
	
	public Profile(long id, String profileName, String firstName, String lastName) {
		this.id = id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = LocalDateTime.now();
	}
	
	public final long getId() {
		return id;
	}
	
	public final void setId(long id) {
		this.id = id;
	}
	
	public final String getProfileName() {
		return profileName;
	}
	public final void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
	public final String getFirstName() {
		return firstName;
	}
	
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public final String getLastName() {
		return lastName;
	}
	
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public final LocalDateTime getCreated() {
		return created;
	}
	
	public final void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	
}
