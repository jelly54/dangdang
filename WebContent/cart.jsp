<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>当当网-可爱的鼠小弟</title>
<script type="text/javascript" src="js/jquery1.10.2.js"></script>
<link href="css/page_03.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>

	<div id="wrapper">
		=
		<!-- header 部分 -->
		<div id="header">
			<!-- 登录信息 -->
			<div id="information">
				<span>您好，</span><a href="###" id="user_name">${sessionScope.username }</a>
				<a href="LoginOutServlet" class="exit">[退出登录]</a>
			</div>
			<!-- 登录信息 END -->
		</div>
		<!-- header 部分 -->

		<div id="content_01"></div>

		<!-- content_02 部分 -->

		<form name="formname" method="post" action="">
			<div>
				<table align="center" border="1">

					<tr>
						<td align="center" width="248">商品名称</td>
						<td align="center" width="183">商品积分</td>
						<td align="center" width="199">当当价</td>
						<td align="center" width="190">数量</td>
						<td align="center" width="134">操作</td>
					</tr>

					<c:forEach items="${books }" var="book">
						<tr>
							<td align="center">图书&nbsp;&nbsp;<img
								style="height: 54px; width: 46px;" src="${book.cover }" /></td>
							<td align="center">10</td>
							<td align="center">${book.price*(book.discount/100) }</td>
							<td align="center"><select name="" id="buy_sum"
								onchange="getAllPrice(this.value,${book. bookid})">
									<option value="${book.bookbuysum }">${book.bookbuysum }</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
							</select> <!--购买数量 --></td>
							<td align="center"><a href="DelCart?bookid=${book. bookid}">删除</a></td>
						</tr>
					</c:forEach>

				</table>

				<p align="right">
					<!-- 商品金额总计 -->
					商品金额总计￥：<span id="all_price">${allPrice }</span>元
				</p>

				<!-- 继续购物 -->
				<div id="goBuy">
					<div align="right">
						<a href="IndexServlet"><img src="images/Page_03_03_buy.jpg"
							alt="" border="0" /></a>
					</div>
				</div>

				<div align="right">
					<!-- 结算按钮 -->
					<a href="address.jsp"><img src="images/Page_03_solve.jpg"
						alt="" border="0" /></a>
				</div>
				<!-- content_03 部分 -->
				<div id="content_03"></div>
				<!-- footer 部分 -->
				<div id="footer"></div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function getAllPrice(change_sum,bookid){
			$.ajax({ url: "countPrice?changesum="+change_sum+"&bookid="+bookid+"&username="+"${sessionScope.username }", 
					context: document.body, 
					success: function(result){
// 					   alert(result);
					   $("#all_price").text(result);
					}
			});
		}
	</script>
</body>
</html>

