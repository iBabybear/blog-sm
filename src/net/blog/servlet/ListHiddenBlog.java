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

/**
 * Servlet implementation class ListHiddenBlog
 */
@WebServlet("/ListHiddenBlog")
public class ListHiddenBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListHiddenBlog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		/*DBTools dbtools = new DBTools();
		List<Blog> blogs = dbtools.FindBlogByUserId(userid);*/
		
		SqlSession sqlSession =MybatisTools.getSqlSession();
		List<Blog> blogs= sqlSession.selectList("net.blog.mapper.BlogMapper.findBlogById",userid);
		sqlSession.commit();
		
			request.setAttribute("s",blogs);
		
		request.getRequestDispatcher("listHidden.jsp").forward(request, response);
	}

}
