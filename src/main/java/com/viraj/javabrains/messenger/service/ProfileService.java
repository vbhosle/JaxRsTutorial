package com.viraj.javabrains.messenger.service;

import java.util.*;

import com.viraj.javabrains.messenger.database.DatabaseClass;
import com.viraj.javabrains.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(DatabaseClass.getNextProfileSequence());
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName() == null || profile.getProfileName().isEmpty()) {
			return null;
		}
		
		profiles.put(profile.getProfileName(), profile);
		
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
