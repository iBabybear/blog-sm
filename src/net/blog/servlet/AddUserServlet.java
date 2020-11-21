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

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import Tools.MybatisTools;
import net.blog.bean.Blog;
import net.blog.bean.User;
import net.blog.util.DBTools;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
		
		//3.���ܲ���
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		
		
		//4.�������ݣ��Զ����ɣ�
		String userid = UUID.randomUUID().toString().replaceAll("-","");
		Date d = new Date();
		//yyyy-MM-dd hh:mm:ss
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String publishDateTime = sdf.format(d);
		int readCount = 0;
		
		//5.��װ����--->>����
	/*	User u = new User();
		u.setUserid(userid);
		u.setUsername(username);
		u.setPassword(password);
		u.setEmail(email);*/
		
		User u = new User(userid, username, password, email);
		//6
		 SqlSession sqlSession =MybatisTools.getSqlSession();
		 int rows = sqlSession.insert("net.blog.mapper.UserMapper.addUser",u);
		 sqlSession.commit();
		 
				if(rows>=0) {
				request.setAttribute("user",u);	
				System.out.println("注册成功");
				request.setAttribute("msg", "成功注册记录");
				}	
				else System.out.println("添加失败");
				request.getRequestDispatcher("/FindBlogsServlet").forward(request,response);
				
	}

}
