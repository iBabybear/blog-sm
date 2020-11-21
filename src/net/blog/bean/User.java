package net.blog.bean;

public class User {
			String userid;
			String username;
			String password;
			String email;
			
			public User(String userid, String username, String password, String email) {
				super();
				this.userid = userid;
				this.username = username;
				this.password = password;
				this.email = email;
			}

			public User() {
				// TODO Auto-generated constructor stub
			}

			public String getUserid() {
				return userid;
			}

			public void setUserid(String userid) {
				this.userid = userid;
			}

			public String getUsername() {
				return username;
			}

			public void setUsername(String username) {
				this.username = username;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			@Override
			public String toString() {
				return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", email="
						+ email + "]";
			}
			
			
			
			
}
