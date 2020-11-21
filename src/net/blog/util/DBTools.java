package net.blog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import net.blog.bean.Blog;
import net.blog.bean.Comment;
import net.blog.bean.User;

//�������ݿ���ʵ�����
public class DBTools {
	/*
	 * 1.��鲢װ������
	 * 2.��������
	 * 3.��ȡ���ʶ���
	 * 4.����SQL���
	 * 5.ִ��
	 * 6.�����������أ��ر����ӣ�
	 * */
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	ArrayList<Blog> blogs = new ArrayList<Blog>();
	ArrayList<Comment> comments = new ArrayList<Comment>();
	@Test
	
	
	
	/**
	 * 驱动加载
	 */
	public void init() {
		//1.��鲢װ������
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?serverTimezone=UTC", "root", "jrc775430");{
				System.out.println("数据库链接成功");
			}
		} 
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动加载异常");
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库链接异常");
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加博客
	 * @param b
	 * @return
	 */
	public int addBlog(Blog b) {
		init();
		try {
			//3.��ȡ���ʶ��� 4.����SQL���
			String sql = "INSERT INTO blog VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,b.getBlogid());
				pstmt.setString(2,b.getTitle());
				pstmt.setString(3,b.getAuthor());
				pstmt.setString(4,b.getType());
				pstmt.setString(5,b.getPublishDateTime());
				pstmt.setString(6,b.getPicture());
				pstmt.setString(7,b.getDescriptor());
				pstmt.setString(8,b.getContent());
				pstmt.setString(9,b.getIsDisplay());
				pstmt.setInt(10,b.getReadCount());
				pstmt.setString(11,b.getUserid());
			//5.ִ��
			int ret = pstmt.executeUpdate();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库添加异常");
			e.printStackTrace();
		}finally {
			close();
		}
		return -1;
	}
	
	
	/**
	 * 查询博客
	 * @return
	 */
	public List<Blog> queryAllBlogs() {
		
		init();
		String sql = "SELECT * FROM blog ORDER BY publishDateTime DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Blog b = new Blog();
			   b.setBlogid(rs.getString("blogid"));
			   b.setTitle(rs.getString("title"));
			   b.setAuthor(rs.getString("author"));
			   b.setType (rs.getString("type"));
			   b.setPublishDateTime(rs.getString("publishDateTime"));
			   b.setPicture(rs.getString("picture"));
			   b.setDescriptor(rs.getString("descriptor"));
			   b.setContent(rs.getString("content"));
			   b.setIsDisplay(rs.getString("isDisplay"));
			   b.setReadCount(rs.getInt("readCount"));
			   blogs.add(b);
				
			}
			return blogs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ��ѯ�쳣");
			e.printStackTrace();
		}finally {
			close();
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
public List<Blog> UpdateById(String Blogid) {
		
		init();
		String sql = "SELECT * FROM blog where blogid = '"+Blogid+"'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Blog b = new Blog();
			   b.setBlogid(rs.getString("blogid"));
			   b.setTitle(rs.getString("title"));
			   b.setAuthor(rs.getString("author"));
			   b.setType (rs.getString("type"));
			   b.setPublishDateTime(rs.getString("publishDateTime"));
			   b.setPicture(rs.getString("picture"));
			   b.setDescriptor(rs.getString("descriptor"));
			   b.setContent(rs.getString("content"));
			   b.setIsDisplay(rs.getString("isDisplay"));
			   b.setReadCount(rs.getInt("readCount"));
			   blogs.add(b);
				
			}
			return blogs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}finally {
			close();
		}
		// TODO Auto-generated method stub
		return null;
	}


/**
 * 更新博客
 * @param b
 * @return
 */
public int updateBlog(Blog b) {
	
	init();
	
	
	try {
		String sql = "update blog set title=?,author=?,type=?,picture=?,descriptor=? ,content=? where blogid= '"+b.getBlogid()+"'";
		
	pstmt = conn.prepareStatement(sql);	
		pstmt.setString(1,b.getTitle());
		pstmt.setString(2,b.getAuthor());
		pstmt.setString(3,b.getType());
		pstmt.setString(4,b.getPicture());
		pstmt.setString(5,b.getDescriptor());
		pstmt.setString(6,b.getContent());
		/*pstmt.setString(5, b.getBlogid());*/

	//5.ִ��
	int upd = pstmt.executeUpdate();
	return upd;	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
	}finally {
		close();
	}
	// TODO Auto-generated method stub
	return -1;
}
  

	

	
	/**
	 * 删除博客
	 * @param b
	 * @return
	 */
  public int deleteBlog(Blog b) {
		init();//��ʼ��
		try {
			//ɾ��
			String ete = "delete from blog where blogid=?";
			pstmt = conn.prepareStatement(ete);
			pstmt.setString(1,b.getBlogid());
		
			int del =pstmt.executeUpdate();
			return del;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库删除异常");
			e.printStackTrace();

		}finally {
			close();
		}
		return -1;

}
	
	
  public  Blog queryBlogByid(String blogid) {
		init();
		String sql = "SELECT * FROM blog WHERE blogid =? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, blogid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Blog b = new Blog();
			   b.setBlogid(rs.getString("blogid"));
			   b.setTitle(rs.getString("title"));
			   b.setAuthor(rs.getString("author"));
			   b.setType (rs.getString("type"));
			   b.setPublishDateTime(rs.getString("publishDateTime"));
			   b.setPicture(rs.getString("picture"));
			   b.setDescriptor(rs.getString("descriptor"));
			   b.setContent(rs.getString("content"));
			   b.setIsDisplay(rs.getString("isDisplay"));
			   b.setReadCount(rs.getInt("readCount"));
			   
				return b;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ��ѯ�쳣");
			e.printStackTrace();
		}finally {
			close();
		}
		// TODO Auto-generated method stub
		return null;
	}

  
 
	
/*----------------------------------------------------------*/
  public int addComment(Comment c) {
		init();
		try {
			//3.��ȡ���ʶ��� 4.����SQL���
			String sql = "INSERT INTO comment VALUES(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,c.getCommentid());
				pstmt.setString(2,c.getName());
				pstmt.setString(3,c.getEmail());
				pstmt.setString(4,c.getContent());
				pstmt.setString(5,c.getCommentDateTime());
				pstmt.setString(6,c.getBlogid());
				pstmt.setString(7,c.getUserid());
				
			//5.ִ��
			int ret = pstmt.executeUpdate();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("评论添加异常");
			e.printStackTrace();
		}finally {
			close();
		}
		return -1;
	}
	
  
  
  public  List<Comment> queryCommentByid(String blogid) {
		init();
		String sql = "SELECT * FROM comment WHERE blogid =? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, blogid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Comment c = new Comment();
			   c.setCommentid(rs.getString("commentid"));
			   c.setName(rs.getString("name"));
			   c.setEmail (rs.getString("email"));
			   c.setContent(rs.getString("content"));
			   c.setCommentDateTime(rs.getString("commentDateTime"));
			   c.setBlogid(rs.getString("blogid"));
			   comments.add(c);
			   
				
			}
			return comments;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ��ѯ�쳣");
			e.printStackTrace();
		}finally {
			close();
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	 
	

public int updateBlogreadcount(String blogid) {
				init();
	try {
		String sql = "UPDATE blog set readcount=readcount+1 WHERE blogid='" + blogid + "'";
		pstmt = conn.prepareStatement(sql);
		int upd = pstmt.executeUpdate();
		return upd;
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("数据库阅读量读取异常");
		e.printStackTrace();
	} finally {
		close();
	}
	return -1;
}

public List<Blog> RankBlog() {
	  init();
		String sql = "SELECT * FROM blog order by readCount desc limit 0,3";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Blog b = new Blog();
				   b.setBlogid(rs.getString("blogid"));
				   b.setTitle(rs.getString("title"));
				   b.setAuthor(rs.getString("author"));
				   b.setType (rs.getString("type"));
				   b.setPublishDateTime(rs.getString("publishDateTime"));
				   b.setPicture(rs.getString("picture"));
				   b.setDescriptor(rs.getString("descriptor"));
				   b.setContent(rs.getString("content"));
				   b.setIsDisplay(rs.getString("isDisplay"));
				   b.setReadCount(rs.getInt("readCount"));
				   b.setUserid(rs.getString("userid"));
				   blogs.add(b);
				
			}
			return blogs;
		}catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}



public int Register(User u) {
	init();
	try {
		//3.��ȡ���ʶ��� 4.����SQL���
		String sql = "INSERT INTO user VALUES(?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,u.getUserid());
			pstmt.setString(2,u.getUsername());
			pstmt.setString(3,u.getPassword());
			pstmt.setString(4,u.getEmail());
			
		//5.ִ��
		int ret = pstmt.executeUpdate();
		return ret;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("注册异常");
		e.printStackTrace();
	}finally {
		close();
	}
	return -1;
}

public User selectAll(User u, HttpSession session) {
	init();
	
	try {
		String ete = "SELECT * FROM user WHERE username=?";
		pstmt = conn.prepareStatement(ete);
		pstmt.setString(1, u.getUsername());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			u = new User();
			u.setUserid(rs.getString("userid"));
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			/*user.add(u);*/
			return u;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close();
	}
	return null;
}

			
			
	
/**
 * 驱动关闭 
 */
public void close() {
try {
	if(rs!=null)
		rs.close();
	if (pstmt != null)
		pstmt.close();
	if (conn != null)
		conn.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	System.out.println("数据库关闭异常");
	e.printStackTrace();
}
}

public List<Blog> FindBlogByUserId(String userid) {
	init();
	String sql = "SELECT * FROM blog WHERE userid =? ";
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Blog b = new Blog();
			   b.setBlogid(rs.getString("blogid"));
			   b.setTitle(rs.getString("title"));
			   b.setAuthor(rs.getString("author"));
			   b.setType (rs.getString("type"));
			   b.setPublishDateTime(rs.getString("publishDateTime"));
			   b.setPicture(rs.getString("picture"));
			   b.setDescriptor(rs.getString("descriptor"));
			   b.setContent(rs.getString("content"));
			   b.setIsDisplay(rs.getString("isDisplay"));
			   b.setReadCount(rs.getInt("readCount"));
			   b.setUserid(rs.getString("userid"));
			   blogs.add(b);
		   
			
		}
		return blogs;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("���ݿ��ѯ�쳣");
		e.printStackTrace();
	}finally {
		close();
	}
	// TODO Auto-generated method stub
	return null;
}

public List<Comment> MyAllComment(String userid) {
	init();
	try {
		String sql = "SELECT * FROM comment where userid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();			
		while (rs.next()) {
			Comment c = new Comment();
			   c.setCommentid(rs.getString("commentid"));
			   c.setName(rs.getString("name"));
			   c.setEmail (rs.getString("email"));
			   c.setContent(rs.getString("content"));
			   c.setCommentDateTime(rs.getString("commentDateTime"));
			   c.setBlogid(rs.getString("blogid"));
			   comments.add(c);

		}
		return comments;
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close();
	}
	return null;
}




public int deleteComment(Comment c) {
	init();//��ʼ��
	try {
		//ɾ��
		String ete = "delete from comment where commentid=?";
		pstmt = conn.prepareStatement(ete);
		pstmt.setString(1,c.getCommentid());
	
		int del =pstmt.executeUpdate();
		return del;
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("数据库删除异常");
		e.printStackTrace();

	}finally {
		close();
	}
	return -1;
}

/*这是查找所有我评论过得博客*/
public List<Blog> MyComment(String userid) {
	init();
	try {
		String sql = "SELECT * FROM blog where blogid IN (SELECT distinct blogid from comment WHERE comment.userid=?) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();			
		while (rs.next()) {
			Blog b = new Blog();
			   b.setBlogid(rs.getString("blogid"));
			   b.setTitle(rs.getString("title"));
			   b.setAuthor(rs.getString("author"));
			   b.setType (rs.getString("type"));
			   b.setPublishDateTime(rs.getString("publishDateTime"));
			   b.setPicture(rs.getString("picture"));
			   b.setDescriptor(rs.getString("descriptor"));
			   b.setContent(rs.getString("content"));
			   b.setIsDisplay(rs.getString("isDisplay"));
			   b.setReadCount(rs.getInt("readCount"));
			  /* b.setUserid(rs.getString("userid"));*/
			   blogs.add(b);
			   Comment c = new Comment();
			   c.setCommentid(rs.getString("commentid"));
			   c.setName(rs.getString("name"));
			   c.setEmail (rs.getString("email"));
			   c.setContent(rs.getString("content"));
			   c.setCommentDateTime(rs.getString("commentDateTime"));
			   c.setBlogid(rs.getString("blogid"));
			   c.setUserid(rs.getString("userid"));
			   comments.add(c);
		}
		return blogs;
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close();
	}
	return null;
}

	
	
}
