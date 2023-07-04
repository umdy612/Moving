<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/resources/inc/adminHeader.jsp" %>
<script>
	var result = '${success}'; console.log( result);
	if(result.length != 0){ alert(result); }
</script>

<div class="container adminContainer">
	<div class="admin">
	<div class="row">
		<h3 class="col-sm-9">영화 관리</h3>
		<div class="col-sm-3"><a href="${pageContext.request.contextPath}/hi/admin_movie/movieInsert.hi" class="btn">영화 등록</a></div>
	</div>
		<table class="table table-striped movieTable">
			<thead>
				<tr><th>NO</th><th>제목</th><th>감독</th>
					<th>등급</th><th>장르</th><th>개봉일</th><th>edit</th></tr>
			</thead>
			<tbody> 
			 <c:forEach var="listt" items="${list }" varStatus="status">
				<tr>
					<td>${list.size() - status.index }</td>
					<td data-toggle="modal" data-target="#myModal" class="movie-title" data-srn="${listt.moviesrn}">${listt.title}</td>
					<td class="movie-director">${listt.director}</td>
					<td class="movie-rating">${listt.rating}</td>
					<td class="movie-genre">${listt.genre}</td>
					<td class="movie-releasedate">${listt.releasedate}</td>
		 			<td>
						<a href="${pageContext.request.contextPath}/hi/admin_movie/movieUpdate?moviesrn=${listt.moviesrn}" class="btn">수정</a>
						<button class="delete" data-role="${listt.moviesrn}">삭제</button>
					</td>
				</tr>
				<input type="hidden" class="movie-detail${listt.moviesrn}" value="${listt.detail}"/>
				<input type="hidden" class="movie-poster${listt.moviesrn}" value="${listt.poster}"/>
				<input type="hidden" class="movie-runningtime${listt.moviesrn}" value="${listt.runningtime}"/>
				<input type="hidden" class="movie-link${listt.moviesrn}" value="${listt.link}"/>
				<input type="hidden" class="movie-closedate${listt.moviesrn}" value="${listt.closedate}"/>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- Modal -->
	  <div class="modal" id="myModal" role="dialog" > 
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title"></h4>
	      </div>
	      <div class="modal-body">
		      <div class="row">
				<div class="col-sm-4">
			        <p id="poster"></p>
				</div>
				<div class="col-sm-8 movie_modal">
			        <p id="director"></p>
			        <p id="genre"></p>
			        <p id="rating"></p>
			        <p id="detail"></p>
			        <p id="runningtime"></p>
			        <p id="releasedate"></p>
			        <p id="closedate"></p>
			        <p id="link"></p>
				</div>
			</div>
			<div id="video">  </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">목록보기</button>
	      </div>
	    </div>
	
	  </div>
	</div>
</div>
<script>
$(function(){
	$(".delete").on("click", function(){
		 var movieDelete = confirm("영화를 삭제하시겠습니까?");

		  if(movieDelete){
		     location.href="movieDelete.hi?moviesrn="+$(".delete").attr("data-role");
		  }else{  //취소 버튼 클릭 false
		    history.go(-1);
		  }
	});
	$(".movie-title").on("click", function(){
		//$("#myModal").modal("show");
		var srn = $(this).attr("data-srn");
		var movieTitle 		 = $(this).text();
		var movieDirector	 = $(this).closest("tr").find(".movie-director").text();
		var movieRating 	 = $(this).closest("tr").find(".movie-rating").text();
		var movieGenre 		 = $(this).closest("tr").find(".movie-genre").text();
		var movieReleasedate = $(this).closest("tr").find(".movie-releasedate").text();
		
		var movieDetail 	 = $(".movie-detail"+srn).val();
		var movieRunningtime = $(".movie-runningtime"+srn).val();
		var movieClosedate   = $(".movie-closedate"+srn).val();
		
		$(".modal-title").text(movieTitle);
		$("#director").html("감독 : " + movieDirector);
		if(movieRating == 'ALL'){ $("#rating").html("전체 관람가"); }
		else{ $("#rating").html(movieRating + "세 이상 관람가");}
		$("#genre").html("장르 : " + movieGenre);
		$("#releasedate").html("상영시작일 : " + movieReleasedate);
		 $("#detail").html("상세 설명<br>" + movieDetail);
		
		$("#runningtime").html("러닝타임 : " + movieRunningtime);
		$("#closedate").html("상영종료일 : " + movieClosedate);
		
		$("#myModal").on('shown.bs.modal', function(){
			var moviePoster = $(".movie-poster"+srn).val();
			var movieLink 	= $(".movie-link"+srn).val();
			//alert(moviePoster +" / "+movieLink);
			$("#poster").html('<p><img alt="' + movieTitle + '" src="/poster/' + moviePoster + '" style="width: 185px; height: 260px;"></p>');
			$("#link").html('예고편 주소 : '+movieLink+'<br>');
			$("#video").html('<iframe width="100%" hight="200px" src="https://www.youtube.com/embed/jBdRhhSt3Bc" title ="YouTube video player"' 
					+'frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"'
					+'allowfullscreen></iframe>');

		});
		
	});

	/* $("#movieTitle").on("click", function(){
		$(".modal-title").html($("#movieTitle").text());
		$("#director").html("감독 : "+ $("#movieDirector").text());
		$("#rating").html($("#movieRating").text()+"세 이상 관람가");
		$("#genre").html("장르 : "+$("#movieGenre").text());
		$("#releasedate").html("상영시작일 : "+$("#movieReleasedate").text());
		$("#detail").html("상세 설명<br>"+$("#movieDetail").val());
		$("#poster").html('<p><img alt="'+$("#movieTitle").text()+'" src="/resources/poster/' + $("#moviePoster").val() + '" style="width: 185px; height: 260px;"></p>');
		$("#runningtime").html("러닝타임 : "+$("#movieRunningtime").val());
		$("#link").html('<iframe width="100%" src="' + $("#movieLink").val() + '" title ="YouTube video player"' 
				+'frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"'
				+'allowfullscreen></iframe>');
		$("#closedate").html("상영종료일 : "+$("#movieClosedate").val());
	}); */
});
</script>
<%@ include file="/resources/inc/adminFooter.jsp" %>