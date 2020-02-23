package com.blog.model;

public class ModelFormData {
	
	private String currentPassword;
	private String newPassword;
	
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	@Override
	public String toString() {
		return "ModelFormData [currentPassword=" + currentPassword + ", newPassword=" + newPassword + "]";
	}
}
