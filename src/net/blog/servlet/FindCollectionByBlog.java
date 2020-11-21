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
 * Servlet implementation class FindCollectionByBlog
 */
@WebServlet("/FindCollectionByBlog")
public class FindCollectionByBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCollectionByBlog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userid = request.getParameter("userid");
		
		
		
		SqlSession sqlSession =MybatisTools.getSqlSession();
		List<Blog> collection= sqlSession.selectList("net.blog.mapper.CollectionMapper.findCollectionById",userid);
		sqlSession.commit();
		request.setAttribute("collection", collection);
		request.getRequestDispatcher("listColletionByBlog.jsp").forward(request, response);
	}

}
