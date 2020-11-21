package net.blog.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class FindBlogsServlet
 */
@WebServlet("/FindBlogsServlet")
public class FindBlogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindBlogsServlet() {
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
		
		/*DBTools dbtools = new DBTools();
		List<Blog> blogs = dbtools.queryAllBlogs();*/
		
		SqlSession sqlSession =MybatisTools.getSqlSession();
		List<Blog> blogs= sqlSession.selectList("net.blog.mapper.BlogMapper.findBlog");
		sqlSession.commit();
		if(blogs.size()>0) {
			request.setAttribute("msg", "blog");
			request.setAttribute("blogs",blogs);
		}
		request.getRequestDispatcher("ListBlogs.jsp").forward(request, response);
		
		
		
	}
	

}
