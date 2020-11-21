package net.blog.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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
 * Servlet implementation class AddCommentServlet
 */
@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��������ַ�ƫ�롢2.����response�ַ�����
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//3.���ܲ���
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		String blogid = request.getParameter("blogid");
		String userid = request.getParameter("userid");
		
		
		
		
		//4.�������ݣ��Զ����ɣ�
		String commentid = UUID.randomUUID().toString().replaceAll("-","");
		Date d = new Date();
		//yyyy-MM-dd hh:mm:ss
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String commentDateTime = sdf.format(d);
		int readCount = 0;
		
		//5.��װ����--->>����
		Comment c =new Comment(commentid, name, email, content, commentDateTime, blogid,userid);
		
		//6�����أ���ʾ���洢��
		
				/*//���浽Blog��
				DBTools dbtools = new DBTools();
				int ret = dbtools.addComment(c);*/
		SqlSession sqlSession =MybatisTools.getSqlSession();
		int ret = sqlSession.insert("net.blog.mapper.CommentMapper.addComment",c);
		sqlSession.commit();		
		
				if(ret>=0) {
					request.getRequestDispatcher("QueryOneBlog?blogid="+blogid).forward(request,response);
					
				}/*else {
					request.getRequestDispatcher("error.jsp").forward(request,response);
				}*/

		
	}

}
