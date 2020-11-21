<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改信息</title>
	<style type="text/css">
	*{
	padding: 0;
	margin: 0;
	}
	.nov{

		height: 50px;
		background-color: #FFFFF;
		border-top: 12px solid #6699FF;
		border-bottom: 3px solid #EDEEF0;
		background-color:#ffffff;

	}
	.nov a{
		display: inline-block;
		height: 50px;
		padding: 0 20px;
		text-decoration: none;
		font-size: 16px;
		font-weight: bold;
		text-align: center;
		color: #6699FF;
	}
	.nov a:hover{
		background-color: #99CCFF;
	}
	body{
	 height:800px;
     width:1900px;
	 /* background-color:#afd5ef; */
	   background-color: #FFEBCD;
	}
	 form{
    
        text-align:center;
        font-size:18px;
        line-height: 330%;
        color:#ffffff;
        font-weight:bold;
        margin-top:100px;
        margin-left:550px;
    }
    h1{
    color:#ffffff;
    letter-spacing: 20px;
    }
    .wj{
    border-radius:30px;
   height:40px;
   width:350px;
    color:pink;
    }
    .anniu{
     height:50px;
      width:200px;
      background-color:#FFFFFF;
      color:#7b7b8f;
      margin-left:70px;
      border-radius:30px;
      font-weight:bold;
      font-size:20px;
    }
   /*  .bg{
    height:250px;
    width:250px;
    background-repeat: no-repeat;
    position: absolute;
    left: 230px;
    top: 170px;
    border-radius:100%;
    }
    .b{
    height:330px;
    width:330px;
    background-repeat: no-repeat;
    position: absolute;
    left: 510px;
    top: 270px;
    border-radius:100%;
    }
    .g{
    height:220px;
    width:220px;
    background-repeat: no-repeat;
    position: absolute;
    left: 280px;
    top: 480px;
    border-radius:100%;
    }
     .u{
     height:200px;
    width:200px;
    background-repeat: no-repeat;
    position: absolute;
    left: 1590px;
    top: 560px;
    border-radius:100%;
    }
    .v{
    height:150px;
    width:150px;
    background-repeat: no-repeat;
    position: absolute;
    left: 1710px;
    top: 400px;
    border-radius:100%;
    }  */
    
    .lianjie{
     width:300px;
     height:60px;
     display:inline-block;
     line-height:60px;
     background-color:#FFFFF0;
     text-align:center;
     color:#DEB887;
     text-decoration:none;
     font-size:20px;
     font-weight:bolder;
    }
	</style>
</head>
<body>



<%-- <c:forEach items="${blog }" var="b"> --%>
<form action="LoginServlet" method="POST" >
<h1>登录账号</h1>
姓名：<input class="wj" type="text" size=30 name="username" ><br/>
密码：<input class="wj" type="text" size=30 name="password"  ><br/>

   <input class="anniu" type="submit" value="登录"/>
</form>
<%-- </c:forEach> --%>
<!-- <img class="bg" src="image/79.jpg">
<img class="b" src="image/99.jpg">
<img class="g" src="image/89.jpg">
<img class="u" src="image/79.jpg">
 <img class="v" src="image/99.jpg"> -->
</body>
</html>