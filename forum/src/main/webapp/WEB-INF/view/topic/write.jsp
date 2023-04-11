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

	<form action="${pageContext.request.contextPath}/topic/write" method="post" enctype="multipart/form-data">
		
		<div>
			<label for="subject">제목 : </label>
			<input type="text" name="subject" id="subject"
				   placeholder="제목 입력" />
		</div>
		<!-- 같은 것이 여러 개가 되면 아이디가 겹치지 않게 처음 것만 빼고 지워 준다 -->
		<div>
			<label for="uploadFile">파일 : </label>
			<input type="file" name="uploadFile" id="uploadFile" placeholder="파일을 선택하세요" />
			<input type="file" name="uploadFile" placeholder="파일을 선택하세요" />
			<input type="file" name="uploadFile" placeholder="파일을 선택하세요" />
		</div>
		<!-- 내용이 여러 줄이면 input 말고 textarea를 쓴다 (input은 한 줄만 가능) -->
		<div>
			<label for="content">내용 : </label>
			<textarea name="content" id="content"
			           placeholder="content"></textarea>
		</div>
		<div>
			<input type="submit" value="등록" />
		</div>
		
	</form>
	
</body>
</html>