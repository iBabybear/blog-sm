package net.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import Tools.MybatisTools;
import net.blog.bean.Blog;
import net.blog.util.DBTools;

/**
 * Servlet implementation class UpdateBlogServlet
 */
@WebServlet("/UpdateBlogServlet")
public class UpdateBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String blogid =request.getParameter("blogid");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String type = request.getParameter("type");
		String picture = request.getParameter("picture");
		String descriptor = request.getParameter("descriptor");
		String content = request.getParameter("content");
		
		System.out.println("这是blogid："+blogid);
		
		Blog b =new Blog();
		b.setBlogid(blogid);
		b.setTitle(title);
		b.setAuthor(author);
		b.setType(type);
		b.setPicture(picture);
		b.setDescriptor(descriptor);
		b.setContent(content);
		
	
		
		/*DBTools dbtools = new DBTools();
		int upd=dbtools.updateBlog(b);*/
		SqlSession sqlSession =MybatisTools.getSqlSession();
		int upd = sqlSession.insert("net.blog.mapper.BlogMapper.updateBlog",b);
		sqlSession.commit();
		if(upd>=0)
			System.out.println("修改成功");
			PrintWriter out =response.getWriter();
			out.print(b.toString());
		
			 request.getRequestDispatcher("/FindBlogsServlet").forward(request,response);
		
	}

}
