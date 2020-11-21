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
import net.blog.bean.Collection;
import net.blog.bean.Comment;

/**
 * Servlet implementation class CollectionBlog
 */
@WebServlet("/CollectionBlog")
public class CollectionBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectionBlog() {
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
		String blogid = request.getParameter("blogid");
		String userid = request.getParameter("userid");
		
		
		
		
		//4.�������ݣ��Զ����ɣ�
		String collectionid = UUID.randomUUID().toString().replaceAll("-","");
		
		
		//5.��װ����--->>����
		Collection c =new Collection();
		c.setCollectionid(collectionid);
		c.setBlogid(blogid);
		c.setUserid(userid);
		
		//6�����أ���ʾ���洢��
		
		SqlSession sqlSession =MybatisTools.getSqlSession();
		int ret = sqlSession.insert("net.blog.mapper.CollectionMapper.addCollection",c);
		sqlSession.commit();		
		
				if(ret>=0) {
					request.getRequestDispatcher("/FindBlogsServlet").forward(request,response);
	}

}
}
