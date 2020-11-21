
<%-- <%@page import="net.blog.bean.Blog"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<style type="text/css">
body {

    background: url(image/aag.jpg);
     background-size:1900px 1000px;
    background-repeat:no-repeat;
    }
     form{
    
        text-align:center;
        font-size:18px;
        line-height: 300%;
        color:#F0F8FF;
        font-weight:bold;
        margin-top:200px;
        margin-left:600px;
    }
    .an{
    height:40px;
      width:230px;
      background-color:#F0F8FF;
      color:#DAA520;
      margin-left:60px;
      border-radius:10px;
      font-size:20px;
      font-weight:bold;
    }
     .ze{
    background-color:#FFEFD5;
    border-radius:10px;
    color:#778899;
    }
  
  body {

    background: url(image/aag.jpg);
     background-size:1900px 1000px;
    background-repeat:no-repeat;
    }
     .b{
  width: 500px;
     height: 800px;
     background-color: rgba(190, 190, 190, 0.6);
     text-align: center;
     position: absolute;
     left: 1200px;
     top: 90px;
     border-radius:60px;
  }
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	Blog blog =new Blog();
	Blog b = (Blog)request.getAttribute("blog");

%> --%>
 <c:forEach items="${blog}" var="b">
<form action="UpdateBlogServlet" method="post ">
<div class="b">
<h1>更新博客</h1>
I D：<input class="ze" type="text" name="blogid" size="40"  value="${b.blogid}"> <br/>
标题：<input class="ze" type="text" name="title" size="40"  value="${b.title}"> <br/>
作者：<input class="ze" type="text" name="author" size="40"  value="${b.author}"> <br/>

类型：<select name="type" class="ze"   > 
		<option value="${b.type}">人生感悟</option>
		<option value="${b.type}">专业发展</option> 
</select><br/>
图片：<input type="radio" name="picture" value="image/picture1.jpg"><img src="image/picture1.jpg" width="64px" height="32px" />
	 <input type="radio" name="picture" value="image/picture2.jpg"><img src="image/picture2.jpg" width="64px" height="32px" />
  	 <input type="radio" name="picture" value="image/picture3.jpg"><img src="image/picture3.jpg" width="64px" height="32px" /><br/>
  	 
简介：<textarea class="ze" name="descriptor" cols=40 rows=8  >${b.descriptor}</textarea><br/>
内容：<textarea class="ze" name="content" cols=40 rows=8>${b.content}</textarea><br/>
 <input class="an" type="submit" value="确定" />
 	</div>
</form>
  </c:forEach>


</body>
</html>