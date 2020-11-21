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
 * Servlet implementation class UpdateByIdServlet
 */
@WebServlet("/UpdateByIdServlet")
public class UpdateByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String blogid= request.getParameter("blogid");
		/*
		DBTools dbtools =new DBTools();
		List<Blog> blog =dbtools.UpdateById(blogid);*/
		
		SqlSession sqlSession =MybatisTools.getSqlSession();
		List<Blog> blog = sqlSession.selectList("net.blog.mapper.BlogMapper.findBlogByBlogId",blogid);
		sqlSession.commit();
		if(blog.size()>0){
			request.setAttribute("blog", blog);
		}
		request.getRequestDispatcher("updateBlog.jsp").forward(request, response);
		
		
	}

}
