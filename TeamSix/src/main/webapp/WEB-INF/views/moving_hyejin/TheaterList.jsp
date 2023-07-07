<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false"%>
<%@ include file= "/resources/inc/adminHeader.jsp" %>
<script>
	var insert = '${insert}';
	if(insert.length != 0){alert(insert);}

	var update = '${update}';
	if(update.length != 0){alert(update);}
	
	var deletem = '${deletem}';
	if(deletem.length != 0){alert(deletem);}
</script>
	<div class="container panel" style="margin-top:30px">
		<h3>영화관 등록</h3>
		<table class="table table-striped text-left">
			<caption>영화관 관리</caption>
			<thead>
				<tr>
					<th scope="col">NO</th>
					<th scope="col">이름</th>
					<th scope="col">상영관 수</th>
					<th scope="col">위치</th>
					<th scope="col">EDIT</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="list" items="${list}" varStatus="status">
		 		<tr><td>${status.count}</td><td>${list.theatername}</td><td>${list.count}</td>
		 		<td>${list.location}</td><td><a href="${pageContext.request.contextPath}/hj/theateredit.hj?theatersrn=${list.theatersrn}" class="btn btn-default">수정하기</a></td></tr>
		 	</c:forEach>
			</tbody>
		</table>
		<div class="regbtn">
		<a href="${pageContext.request.contextPath}/hj/theaterreg.hj" class="btn btn-info" id="regbtn">영화관 등록</a>
		</div>
	</div>
	
<%@ include file= "/resources/inc/adminFooter.jsp" %>