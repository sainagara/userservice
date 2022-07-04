package com.user.Dto;

public class UpdatePasswordDto {
	private String oldPassword;
	private String newPassword;
	private String confirmNewPassword;
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

}
