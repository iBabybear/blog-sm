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
 * Servlet implementation class QueryOneBlog
 */
@WebServlet("/QueryOneBlog")
public class QueryOneBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryOneBlog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String blogid=request.getParameter("blogid");
		
		/*DBTools dbtools = new DBTools();*/
		/*Blog b =dbtools.queryBlogByid(blogid);*/
		
		/*List<Comment> comments = dbtools.queryCommentByid(blogid);*/
		/*int upd=dbtools.updateBlogreadcount(blogid);*/
		/*List<Blog> blogs = dbtools.RankBlog();*/
		
		
		SqlSession sqlSession =MybatisTools.getSqlSession();
		int upd=sqlSession.insert("net.blog.mapper.BlogMapper.updateBlogreadcount",blogid);
		List<Blog> blogs= sqlSession.selectList("net.blog.mapper.BlogMapper.rankBlog");
		List<Comment> comments=sqlSession.selectList("net.blog.mapper.CommentMapper.findCommentByBlogId",blogid);
		Blog b = sqlSession.selectOne("net.blog.mapper.BlogMapper.findBlogByBlogId",blogid);
		sqlSession.commit();
		if (b!=null&&upd>0) {
			request.setAttribute("blogs",blogs);
			request.setAttribute("b",b);
			request.setAttribute("cs",comments);
			request.getRequestDispatcher("post.jsp").forward(request, response);
		}
	}

}
