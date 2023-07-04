<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false"%>
<%@ include file= "/resources/inc/header.jsp" %>
<div class="container panel" style="margin-top:30px; margin-bottom:100px">
	<div class="row">
		<div class="col-sm-2 panel panel-group panel-default">
			<h4 class="mypagehead panel-heading">My Moving</h4>
			<ul class="nav nav-pills nav-stacked">
				<li><a href="${pageContext.request.contextPath}/hj/mypageticket.hj" class="panel-body">예매내역</a></li>
				<li><a href="${pageContext.request.contextPath}/hj/mymovinglist.hj" class="panel-body">자주가는 Moving</a></li>
				<li><a href="${pageContext.request.contextPath}/hi/mypage/MyPage_reply.hi" class="panel-body">내가 쓴 댓글</a></li>
				<li><a href="#" class="panel-body">회원정보수정</a></li>
			</ul>
		</div>
		
		<div class="col-sm-10">
		<h4>내가 쓴 댓글</h4>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">NO</th>
						<th scope="col">영화제목</th>
						<th scope="col">댓글</th>
						<th scope="col">작성일시</th>
						<th scope="col">별점</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="list" items="${reply}" varStatus="status" >
					<tr>
						<td>${status.count}</td>
						<td>${list.title}</td>
						<td>${list.replycontent}</td>
						<td>${list.replydate}</td>
						<td>
 							<c:forEach begin="1" end="${list.star}">
                    			<span>★</span>
                			</c:forEach>
                		</td> 
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
	
<%@ include file= "/resources/inc/footer.jsp" %>