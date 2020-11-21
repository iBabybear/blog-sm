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


/**
 * Servlet implementation class AddBlogServlet
 */
@WebServlet("/AddBlogServlet")
public class AddBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 
		 * 1.��������ַ�ƫ��
		 * 2.����response�ַ�����
		 * 3.���ܲ���
		 * 4.�������ݣ��Զ����ɣ�
		 * 5.��װ����--->>����
		 * 6.���أ���ʾ���洢��
		 * 
		 * 
		 */
		
		//1.��������ַ�ƫ�롢2.����response�ַ�����
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//3.���ܲ���
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String type = request.getParameter("type");
		String picture = request.getParameter("picture");
		String descriptor = request.getParameter("descriptor");
		String content = request.getParameter("content");
		String isDisplay = request.getParameter("isDisplay");
		String userid = request.getParameter("userid");
		
		
		
		//4.�������ݣ��Զ����ɣ�
		String blogid = UUID.randomUUID().toString().replaceAll("-","");
		Date d = new Date();
		//yyyy-MM-dd hh:mm:ss
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String publishDateTime = sdf.format(d);
		int readCount = 0;
		
		//5.��װ����--->>����
		Blog b =new Blog(blogid, title, author,type, publishDateTime,picture,descriptor,content,
			 isDisplay,readCount,userid);
		
		//6�����أ���ʾ���洢��
		
				//���浽Blog��
				/*DBTools dbtools = new DBTools();
				int ret = dbtools.addBlog(b);*/
				
				/*if(ret>=0)
					System.out.println("添加成功");
				System.out.println(b);
				response.getWriter().print(b);	request.getRequestDispatcher("/FindBlogsServlet").forward(request,response);*/
		
		SqlSession sqlSession =MybatisTools.getSqlSession();
		int ret = sqlSession.insert("net.blog.mapper.BlogMapper.addBlog",b);
		sqlSession.commit();
		
				 if(ret>=0) {
						request.setAttribute("blog",b);	
					}	else System.out.println("添加失败");
					request.getRequestDispatcher("/FindBlogsServlet").forward(request,response);
					
	}
	

}
