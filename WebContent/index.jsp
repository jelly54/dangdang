<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<title>当当网-名社新书大PK</title>
<link href="css/page_01.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/ie6.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/ie7.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
<div id="wrapper">
  <!-- header 部分 -->
  <div id="header">
  	<!-- 登录信息 -->
  	<div id="information">
    	<span>您好，</span><a href="###" >${sessionScope.username }</a> <a href="LoginOutServlet" class="exit">[退出登录]</a>
        <!-- 搜索 -->
        <div class="search">
        <form action="SearchServlet" method="get">
        <input class="searchInput" type="text" name="name"/><input type="submit" value="" class="searchBtn" />
        </form>
        </div><!-- 搜索 END -->
    </div><!-- 登录信息 END-->
  </div><!-- header END -->
  
  <div id="banner"></div>
  
  <!-- content 部分 -->
  <div id="content">
  <!-- 图书商品分类 -->
  <div class="content-left">
		<ul>
			<c:forEach var="tb" items="${tlist }">
				<li><a href="TypeServlet?id=${tb.id }">${tb.typename }</a></li>
			</c:forEach>
		</ul>
	</div>
	<!-- 图书商品分类 END -->

	<div class="content-right">
        <!-- 排序条件（评分、价格等） -->
    	<div class="row01">
          <p class="px">
            <a href="###"><img src="images/xl.jpg"  /></a>&nbsp;
            <a href="###"><img src="images/pf.jpg"  /></a>&nbsp;
            
            <a href="OrderServlet?"><img src="images/jg.jpg"  /></a>&nbsp;
            
            <a href="###"><img src="images/zk.jpg"  /></a>&nbsp;
            <a href="###"><img src="images/cbsj.jpg"  /></a>
         </p>
        </div><!-- 排序条件（评分、价格等） END -->
        
        <!-- 循环内容 part 1 -->
       <c:forEach var="bb" items="${blist }">
        <div class="row02">
        	<a href="DetilServlet?bookid=${bb.bookid }"><img src="${bb.cover }" height="130" width="130"/></a>
        	<h2><a href="DetilServlet?bookid=${bb.bookid }">${bb.bookName }</a></h2>
            <p>
            &nbsp;&nbsp;&nbsp;作者：
            <a href="DetilServlet?bookid=${bb.bookid }">${bb.author }</a>
            &nbsp;&nbsp;&nbsp;出版社：
            <a href="DetilServlet?bookid=${bb.bookid }">${bb.bpublic }</a>
            </p>
            <p>
				${bb.introduce }            
            </p>
            <form action="DetilServlet" method="get">
            	<p class="p02">
           		 	<span class="red">￥${bb.price*(bb.discount/100) }</span> &nbsp;&nbsp;
           		 	<span class="line-through">￥${bb.price }
           		 	</span> &nbsp;&nbsp;折扣：${bb.discount }折
           		 	<input type="hidden" name="bookid"  value="${bb.bookid }"/>
            		<input type="submit" class="buy" value=""/>
           	   </p>
            </form>
        </div>
        </c:forEach>
                
        <!-- 分页 -->
        <div class="row04">
        <a href="#">上一页</a> <a href="#"> 1 </a> <a href="#"> 2</a> <a href="#"> 3 </a> <a href="#">下一页</a>
        &nbsp;&nbsp;共<span>5</span>页 到第<input type="text" class="inputPage" />页
        </div><!-- 分页 END -->
    </div><!-- content-right部分 END -->
  </div><!-- content部分 END -->
 
  
  <!-- footer 部分 -->
  <div id="footer"></div>
</div>
</body>
</html>
