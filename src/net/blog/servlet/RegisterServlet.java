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

import net.blog.bean.Blog;
import net.blog.bean.User;
import net.blog.util.DBTools;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		User u = new User(userid, username, password, email);
		
		//6�����أ���ʾ���洢��
		
				//���浽Blog��
				DBTools dbtools = new DBTools();
				int ret = dbtools.Register(u);
				
				if(ret>=0)
					System.out.println("注册成功");
				request.setAttribute("msg", "成功注册记录");
				request.setAttribute("user", u);
		
				
				
				
				request.getRequestDispatcher("index.jsp").forward(request,response);
		
	}
	}


