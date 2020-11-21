package net.blog.bean;

public class Blog {
	String blogid;
	String title;
	String author;
	String type;
	String publishDateTime;
	String picture;
	String descriptor;
	String content;
	String isDisplay;
	int readCount;
    String userid; 
	
	public Blog() {
		// TODO Auto-generated constructor stub
	}

	public Blog(String blogid, String title, String author, String type, String publishDateTime, String picture,
			String descriptor, String content, String isDisplay, int readCount, String userid) {
		super();
		this.blogid = blogid;
		this.title = title;
		this.author = author;
		this.type = type;
		this.publishDateTime = publishDateTime;
		this.picture = picture;
		this.descriptor = descriptor;
		this.content = content;
		this.isDisplay = isDisplay;
		this.readCount = readCount;
		this.userid = userid;
	}

	public String getBlogid() {
		return blogid;
	}

	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPublishDateTime() {
		return publishDateTime;
	}

	public void setPublishDateTime(String publishDateTime) {
		this.publishDateTime = publishDateTime;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(String isDisplay) {
		this.isDisplay = isDisplay;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Blog [blogid=" + blogid + ", title=" + title + ", author=" + author + ", type=" + type
				+ ", publishDateTime=" + publishDateTime + ", picture=" + picture + ", descriptor=" + descriptor
				+ ", content=" + content + ", isDisplay=" + isDisplay + ", readCount=" + readCount + ", userid="
				+ userid + "]";
	}
		
	//��װ����	
	






		



		}


		
		
	
		
           
           
		   
           

