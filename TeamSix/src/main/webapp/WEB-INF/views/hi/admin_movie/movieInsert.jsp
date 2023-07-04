<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/inc/adminHeader.jsp" %>
<div class="container adminContainer">
	<form action="${pageContext.request.contextPath}/hi/admin_movie/movieInsert.hi" method="post" encType="multipart/form-data">
		<fieldset>
			<legend>영화등록</legend>
			<div class="form-group">
				<label for="title">제목</label>
				<input type="text" id="title" name="title" class="form-control" />
			</div>
			<div class="form-group">
				<label for="director">감독</label>
				<input type="text" id="director" name="director" class="form-control" />
			</div>
			<div class="form-group">
				<label for="genre">장르</label>
				<select id="genre" name="genre" class="form-control">
					<option value="default">선택해주세요</option>
					<option value="액션">액션</option>
					<option value="로맨스">로맨스</option>
					<option value="애니메이션">애니메이션</option>
					<option value="코미디">코미디</option>
					<option value="범죄">범죄</option>
					<option value="드라마">드라마</option>
					<option value="판타지">판타지</option>
					<option value="호러">호러</option>
					<option value="SF">SF</option>
					<option value="스릴러">스릴러</option>
					<option value="다큐멘터리">다큐멘터리</option>
					<option value="뮤지컬">뮤지컬</option>
				</select >
			</div>
			<div class="form-group">
				<label for="rating">등급</label>
				<select id=rating name="rating" class="form-control">
					<option value="default">선택해주세요</option>
					<option value="ALL">전체관람가</option>
					<option value="12">12세이상관람가</option>
					<option value="15">15세이상관람가</option>
					<option value="19">청소년관람불가</option>
				</select>
			</div>
			<div class="form-group">
				<label for="runningtime">러닝타임</label>
				<input type="text" id="runningtime" name="runningtime" class="form-control" value="분" />
			</div>
			<div class="form-group">
				<label for="detail">상세설명</label>
				<input type="text" id="detail" name="detail" class="form-control" />
			</div>
			<div class="form-group">
				<label for="releasedate">개봉일</label>
				<input type="date" id="releasedate" name="releasedate" class="form-control" />
			</div>
			<div class="form-group">
				<label for="closedate">상영 종료일</label>
				<input type="date" id="closedate" name="closedate" class="form-control" />
			</div>
			<div class="form-group">
				<label for="file">포스터</label>
				<input type="file" id="file" name="file" class="form-control" />
			</div>
			<div class="form-group">
				<label for="link">예고편 링크</label>
				<input type="url" id="link" name="link" class="form-control" />
			</div>
			<div class="form-group  text-right">
				<input type="submit"   value="등록"  class="btn"    >  
				<input type="reset"   onclick="history.go(-1);"    value="취소"  class="btn"    >  
				<a href="${pageContext.request.contextPath}/hi/adminMovie.hi"   class="btn"   >목록보기</a>
			</div>
		</fieldset>
	</form>
</div>
<%@ include file="/resources/inc/adminFooter.jsp" %>