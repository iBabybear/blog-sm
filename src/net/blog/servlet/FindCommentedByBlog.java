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
import net.blog.bean.Comment;
import net.blog.util.DBTools;

/**
 * Servlet implementation class FindCommentedByBlog
 */
@WebServlet("/FindCommentedByBlog")
public class FindCommentedByBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCommentedByBlog() {
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
		
		/*DBTools dbtools = new DBTools();     
		List<Comment> comments = dbtools.MyAllComment(userid);*/
		
		SqlSession sqlSession =MybatisTools.getSqlSession();
		List<Blog> comments= sqlSession.selectList("net.blog.mapper.CommentMapper.findCommentById",userid);
		sqlSession.commit();
		request.setAttribute("s", comments);
		request.getRequestDispatcher("listCommentsByBlog.jsp").forward(request, response);
	}

}
