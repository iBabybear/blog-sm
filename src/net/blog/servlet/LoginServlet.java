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
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import Tools.MybatisTools;
import net.blog.bean.User;
import net.blog.util.DBTools;

/**
 * Servlet implementation class FindUsersServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		//3.获取参数
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		
		
		
		
		//5.封装
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setUserid(userid);
		
		//6
		
				//存到user表里
				/*DBTools dbtools = new DBTools();
				HttpSession session = request.getSession();
				User res = dbtools.selctAll(u,session);*/
				
				SqlSession sqlsession =MybatisTools.getSqlSession();
				User res = sqlsession.selectOne("net.blog.mapper.UserMapper.userLogin",u);
				sqlsession.commit();
				
				if(res != null) {
					if (res.getPassword().equals(password)) {
						HttpSession session = request.getSession();
						session.setAttribute("loginuser", res);
						System.out.println("登录成功");
						/*request.getRequestDispatcher("ListBlogs.jsp").forward(request,response);*/
						/*response.sendRedirect(request.getContextPath()+"/FindBlogsServlet");*/
						request.getRequestDispatcher("/FindBlogsServlet").forward(request,response);
						return;
					}else System.out.println("账号密码错误");
					request.getRequestDispatcher("index.jsp").forward(request,response);
					}else { System.out.println("登录失败");
				request.getRequestDispatcher("index.jsp").forward(request,response);
					
					}
		
	}

}
