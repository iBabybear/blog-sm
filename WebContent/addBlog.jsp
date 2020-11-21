<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Xtra Blog</title>
	<link rel="stylesheet" href="fontawesome/css/all.min.css"> <!-- https://fontawesome.com/ -->
	<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet"> <!-- https://fonts.google.com/ -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/templatemo-xtra-blog.css" rel="stylesheet">
<!--
    
TemplateMo 553 Xtra Blog

https://templatemo.com/tm-553-xtra-blog

-->
</head>
<body>
	<header class="tm-header" id="tm-header">
        <div class="tm-header-wrapper">
            <button class="navbar-toggler" type="button" aria-label="Toggle navigation">
                <i class="fas fa-bars"></i>
            </button>
            <div class="tm-site-header">
                <div class="mb-3 mx-auto tm-site-logo"><i class="fas fa-times fa-2x"></i></div>            
                <h1 class="text-center">Xtra Blog</h1>
            </div>
            <nav class="tm-nav" id="tm-nav">            
                <ul>
                    <li class="tm-nav-item"><a href="FindBlogsServlet" class="tm-nav-link">
                        <i class="fas fa-home"></i>
                        Blog Home
                    </a></li>
                    <li class="tm-nav-item active"><a href="post.html" class="tm-nav-link">
                        <i class="fas fa-pen"></i>
                        Single Post
                    </a></li>
                    <li class="tm-nav-item"><a href="about.html" class="tm-nav-link">
                        <i class="fas fa-users"></i>
                        About Xtra
                    </a></li>
                    <li class="tm-nav-item"><a href="index.jsp" class="tm-nav-link">
                        <i class="far fa-comments"></i>
                        Log Out
                    </a></li>
                </ul>
            </nav>
            <div class="tm-mb-65">
                <a href="https://facebook.com" class="tm-social-link">
                    <i class="fab fa-facebook tm-social-icon"></i>
                </a>
                <a href="https://twitter.com" class="tm-social-link">
                    <i class="fab fa-twitter tm-social-icon"></i>
                </a>
                <a href="https://instagram.com" class="tm-social-link">
                    <i class="fab fa-instagram tm-social-icon"></i>
                </a>
                <a href="https://linkedin.com" class="tm-social-link">
                    <i class="fab fa-linkedin tm-social-icon"></i>
                </a>
            </div>
            <p class="tm-mb-80 pr-5 text-white">
                Xtra Blog is a multi-purpose HTML template from TemplateMo website. Left side is a sticky menu bar. Right side content will scroll up and down.
            </p>
        </div>
    </header>
    <div class="container-fluid">
        <main class="tm-main">
            <!-- Search form -->
            <div class="row tm-row">
                <div class="col-12">
                    <form method="GET" class="form-inline tm-mb-80 tm-search-form">                
                        <input class="form-control tm-search-input" name="query" type="text" placeholder="Search..." aria-label="Search">
                        <button class="tm-search-button" type="submit">
                            <i class="fas fa-search tm-search-icon" aria-hidden="true"></i>
                        </button>                                
                    </form>
                </div>                
            </div>            
            <div class="row tm-row">
                <div class="col-12">
                    <hr class="tm-hr-primary tm-mb-55">
                    <!-- Video player 1422x800 -->
                    <video width="954" height="535" controls class="tm-mb-40">
                        <source src="video/wheat-field.mp4" type="video/mp4">							  
                        Your browser does not support the video tag.
                    </video>
                </div>
            </div>
            <div class="row tm-row">
                <div class="col-lg-8 tm-post-col">
                    <div class="tm-post-full">                    
                       
                        
                        <!-- Comments -->
                        <div>
                            <h2 class="tm-color-primary tm-post-title">添加博客</h2>
                            <hr class="tm-hr-primary tm-mb-45">
                            
                            <form action="AddBlogServlet" class="mb-5 tm-comment-form" method="post">
                                <h2 class="tm-color-primary tm-post-title mb-4"></h2>
                                <div class="mb-4">
                                    <h5 class="tm-color-primary">标题：<input class="form-control" name="title" type="text"> </h5>
                                </div>
                                <div class="mb-4">
                                    <h5 class="tm-color-primary">作者：<input class="form-control" name="author" type="text" value="${loginuser.username}" readonly="readonly"></h5>
                                </div>
                               <div class="mb-4"> 
                                <select name="type" class="ze"   > 
									<option value="人生感悟"> <h4 class="tm-color-primary">人生感悟</h4></option>
									<option value="专业发展"><h4 class="tm-color-primary">专业发展</h4></option> 
								</select><br>
								</div>
								<input type="radio" name="picture" value="img/img-01.jpg"><img src="img/img-01.jpg" width="100px" height="50px" />
	 <input type="radio" name="picture" value="img/img-02.jpg"><img src="img/img-02.jpg" width="100px" height="50px" />
  	 <input type="radio" name="picture" value="img/img-03.jpg"><img src="img/img-03.jpg" width="100px" height="50px" /><br/>
  	 
  	 							<div class="mb-4">
                                   <h5 class="tm-color-primary"> 简介：<textarea class="form-control" name="descriptor" rows="6"></textarea></h5>
                                </div>
                                <div class="mb-4">
                               	     <h5 class="tm-color-primary"> 内容：<textarea class="form-control" name="content" rows="6"></textarea></h5>
                                </div>
                                <input type="hidden" name="userid" value="${loginuser.userid}" />
					<h5 class="tm-color-primary">是否可见：<input type="radio" name="isDisplay" value="1" >是
 					 <input type="radio" name="isDisplay" value="0" >否</h5><br/>
                                <div class="text-right">
                                    <button class="tm-btn tm-btn-primary tm-btn-small" name="submit">Submit</button>                        
                                </div>                                
                            </form>                          
                        </div>
                    </div>
                </div>
                <aside class="col-lg-4 tm-aside-col">
                    <div class="tm-post-sidebar">
                        <hr class="mb-3 tm-hr-primary">
                        <h2 class="mb-4 tm-post-title tm-color-primary">Categories</h2>
                        <ul class="tm-mb-75 pl-5 tm-category-list">
                            <li><a href="#" class="tm-color-primary">Visual Designs</a></li>
                            <li><a href="#" class="tm-color-primary">Travel Events</a></li>
                            <li><a href="#" class="tm-color-primary">Web Development</a></li>
                            <li><a href="#" class="tm-color-primary">Video and Audio</a></li>
                            <li><a href="#" class="tm-color-primary">Etiam auctor ac arcu</a></li>
                            <li><a href="#" class="tm-color-primary">Sed im justo diam</a></li>
                        </ul>
                        <hr class="mb-3 tm-hr-primary">
                        <h2 class="tm-mb-40 tm-post-title tm-color-primary">HOT Posts</h2>
                     <c:forEach items="${blogs}" var="b">    
                        <a href="#" class="d-block tm-mb-40">
                            <figure>
                                <img src="${b.picture}" alt="Image" class="mb-3 img-fluid">
                                <figcaption class="tm-color-primary">${b.descriptor}</figcaption>
                            </figure>
                        </a>
                       </c:forEach> 
                        
                    </div>                    
                </aside>
            </div>
            <footer class="row tm-row">
                <div class="col-md-6 col-12 tm-color-gray">
                    Design: <a rel="nofollow" target="_parent" href="https://templatemo.com" class="tm-external-link">TemplateMo</a>
                </div>
                <div class="col-md-6 col-12 tm-color-gray tm-copyright">
                    Copyright 2020 Xtra Blog Company Co. Ltd.
                </div>
            </footer>
        </main>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/templatemo-script.js"></script>
</body>
</html>