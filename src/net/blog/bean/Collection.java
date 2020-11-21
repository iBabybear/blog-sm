package net.blog.bean;

public class Collection {
			String collectionid;
			String blogid;
			String userid;
			
			
			public Collection() {}


			public Collection(String collectionid, String blogid, String userid) {
				super();
				this.collectionid = collectionid;
				this.blogid = blogid;
				this.userid = userid;
			}


			public String getCollectionid() {
				return collectionid;
			}


			public void setCollectionid(String collectionid) {
				this.collectionid = collectionid;
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
				return "Collection [collectionid=" + collectionid + ", blogid=" + blogid + ", userid=" + userid + "]";
			}
			
			
}
