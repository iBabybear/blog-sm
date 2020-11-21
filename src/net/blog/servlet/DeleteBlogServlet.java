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
 * Servlet implementation class DeleteBlogServlet
 */
@WebServlet("/DeleteBlogServlet")
public class DeleteBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBlogServlet() {
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
		
		//��request���л�ȡ��������String����
		String blogid = request.getParameter("blogid");
		Blog b=new Blog();
		b.setBlogid(blogid);
		
		/*DBTools dbtools = new DBTools();
		int del=dbtools.deleteBlog(b);*/
		
		SqlSession sqlSession =MybatisTools.getSqlSession();
		int del = sqlSession.insert("net.blog.mapper.BlogMapper.deleteBlogById",b);
		sqlSession.commit();

		if(del>=0)
			System.out.println("�ɹ�ɾ��һ����¼");
			PrintWriter out =response.getWriter();
			out.print(b.toString());
			
		//ͨ��Interger.parseInt()��������String����ת��Ϊint����
//		dbtools.deleteById(Integer.parseInt(blogid));
        request.getRequestDispatcher("/FindBlogsServlet").forward(request,response);
	}

}
