package net.blog.bean;

public class Comment {
     String commentid;
     String name;
     String email;
     String content;
     String commentDateTime;
     String blogid;
     String userid;
     
     
     public Comment() {}


	public Comment(String commentid, String name, String email, String content, String commentDateTime, String blogid,
			String userid) {
		super();
		this.commentid = commentid;
		this.name = name;
		this.email = email;
		this.content = content;
		this.commentDateTime = commentDateTime;
		this.blogid = blogid;
		this.userid = userid;
	}


	public String getCommentid() {
		return commentid;
	}


	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getCommentDateTime() {
		return commentDateTime;
	}


	public void setCommentDateTime(String commentDateTime) {
		this.commentDateTime = commentDateTime;
	}


	public String getBlogid() {
		return blogid;
	}


	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", name=" + name + ", email=" + email + ", content=" + content
				+ ", commentDateTime=" + commentDateTime + ", blogid=" + blogid + ", userid=" + userid + "]";
	}


	
     
}
