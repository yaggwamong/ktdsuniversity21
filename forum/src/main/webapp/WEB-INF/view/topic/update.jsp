<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<form action="${pageContext.request.contextPath}/topic/update/${topic.id}" method="post">
		
		<div>
			<label for="subject">제목 : </label>
			<input type="text" name="subject" id="subject"
				   value="${topic.subject}" placeholder="제목 입력" />
		</div>
		<div>
			<label for="email">이메일 : </label>
			<input type="email" name="email" id="email"
				   value="${topic.email}" placeholder="이메일 입력" />
		</div>
		<!-- 내용이 여러 줄이면 input 말고 textarea를 쓴다 (input은 한 줄만 가능) -->
		<div>
			<label for="content">내용 : </label>
			<textarea name="content" id="content"
			           placeholder="content">${topic.content}</textarea>
		</div>
		<div>
			<input type="submit" value="수정" />
		</div>
		
	</form>
	
</body>
</html>