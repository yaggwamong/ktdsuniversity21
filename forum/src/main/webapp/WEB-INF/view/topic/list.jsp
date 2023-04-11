<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
	$().ready(function() {
		
	});
</script>
</head>
<body>
	
	<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
	
	<img src="${pageContext.request.contextPath}/img/Instagram-Icon.png" style="width: 30px; height: 30px;" />
	
	<h1>Topics</h1>
	
	<!-- 한 칸에 한 정보만 -> table / 한 칸에 여러 정보 -> ul -->
	<div>총 ${topicList.size()}건</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>글 번호</th>
					<th>글 제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty topicList}">
						<c:forEach items="${topicList}" var="topic">
							<tr>
								<td>${topic.id}</td>
								<td>
									<a href="${pageContext.request.contextPath}/topic/${topic.id}">
										${topic.subject} (${topic.replyList.size()})
									</a>
								</td>
								<td>${topic.memberVO.name}</td>
								<td>${topic.crtDt}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4">
								등록된 토픽이 없습니다.
								첫 번째 토픽의 주인공이 되어보세요!
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	
	
	
	
	
	
	<div>
		<a href="${pageContext.request.contextPath}/topic/write">토픽 작성</a>
	</div>

</body>
</html>