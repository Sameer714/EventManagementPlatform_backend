package com.example.EventManagementPlatform.model;

public class GlobalInput {
	public static class CheckOtp {

		private String email;
		private String otp;
		private String newPass;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getOtp() {
			return otp;
		}
		public void setOtp(String otp) {
			this.otp = otp;
		}
		public String getNewPass() {
			return newPass;
		}
		public void setNewPass(String newPass) {
			this.newPass = newPass;
		}
		
	}
	
	public class Messg {
		private String fail ;

		public String getFail() {
			return fail;
		}

		public void setFail(String fail) {
			this.fail = fail;
		}

		public Messg(String fail) {
			super();
			this.fail = fail;
		}

		@Override
		public String toString() {
			return "Messg [fail=" + fail + "]";
		}

		public Messg() {
			super();
			}
	}
	
	public class UserPass {
		private String email;
		private String newPass;
		
		public UserPass(String email, String pass) {
			super();
			this.email = email;
			this.newPass = pass;
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getNewPass() {
			return newPass;
		}
		public void setNewPass(String pass) {
			this.newPass = pass;
		}
		
		@Override
		public String toString() {
			return "UserPass [email=" + email + ", pass=" + newPass + "]";
		}
		
		public UserPass() {
			super();
		}
	}
	
	public static class Emailbody {
		private String from;
		private String name;
		private String sub;
		private String content;
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSub() {
			return sub;
		}
		public void setSub(String sub) {
			this.sub = sub;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		@Override
		public String toString() {
			return "Emailbody [from=" + from + ", name=" + name + ", sub=" + sub + ", content=" + content + "]";
		}
		public Emailbody(String from, String name, String sub, String content) {
			super();
			this.from = from;
			this.name = name;
			this.sub = sub;
			this.content = content;
		}
		public Emailbody() {
			super();
		}
	}

}
