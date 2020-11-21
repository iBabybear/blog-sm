package net.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import Tools.MybatisTools;
import net.blog.bean.Blog;
import net.blog.bean.Comment;
import net.blog.util.DBTools;

/**
 * Servlet implementation class DeleteCommentServlet
 */
@WebServlet("/DeleteCommentServlet")
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentServlet() {
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
		String commentid = request.getParameter("commentid");
		Comment c=new Comment();
		c.setCommentid(commentid);
		
		/*DBTools dbtools = new DBTools();
		int del=dbtools.deleteComment(c);*/
		
		SqlSession sqlSession =MybatisTools.getSqlSession();
		int del = sqlSession.insert("net.blog.mapper.CommentMapper.deleteCommentByld",c);
		sqlSession.commit();
		if(del>=0)
			System.out.println("");
			PrintWriter out =response.getWriter();
			out.print(c.toString());
			

        request.getRequestDispatcher("/FindBlogsServlet").forward(request,response);
	}

}
