<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
	$().ready(function() {
		
		$("#login_btn").click(function(event) {
			event.preventDefault();
			
			var emailValue = $("#email").val();
			var passwordValue = $("#password").val();
			
			if (emailValue == '') {
				alert("이메일을 입력하세요!");
				return;
			}
			if (passwordValue == '') {
				alert("비밀번호를 입력하세요!");
				return;
			}
			
			// Ajax 요청
			/* $.post("URL", {data}, function(response) {}) <- 기본 형태 :  */
			$.post("${pageContext.request.contextPath}/api/member/login",    // URL
					{email: emailValue, password: passwordValue},    // 전송 DATA
					function(response) {
						console.log(response);
						if (response.loginResult) {
							// 페이지 이동
							location.href = "${pageContext.request.contextPath}/topics";
						}
						else if (response.errorcode == "NOT_FOUND_USER") {
							alert("아이디 또는 비밀번호가 일치하지 않습니다.");
						}
						else if (response.status == "fail") {
							// 서버의 Validation Check 로직에 걸린 경우
							alert(response.message);
						}
					});    // Response
		});
		
		// 이 아래는 예전 방식 -> Ajax 방식으로 변경함
		
		// jquery에서 같다 -> eq / 같지 않다 -> ne
		/* <c:if test="${errorCode eq 'NOT_FOUND_USER'}">
			alert("아이디 또는 비밀번호가 일치하지 않습니다");
		</c:if>
		
		$("#login_btn").click(function(event) {
			event.preventDefault();
			
			var emailValue = $("#email").val();
			var passwordValue = $("#password").val();
			
			if (emailValue == '') {
				alert("이메일을 입력하세요!");
				return;
			}
			if (passwordValue == '') {
				alert("비밀번호를 입력하세요!");
				return;
			}
			
			$("#login_form").attr({
				"action": "${pageContext.request.contextPath}/member/login",
				"method": "post"
			}).submit();
		}); */
		
	});
</script>
</head>
<body>
	
	<h1>Login</h1>
	
	<form id="login_form">
	
		<div>
			<label for="email">로그인 이메일</label>
			<input type="email" id="email" name="email" />
		</div>
		<div>
			<label for="password">로그인 비밀번호</label>
			<input type="password" id="password" name="password" />
		</div>
		<div>
			<button id="login_btn">로그인</button>
		</div>
		
	</form>
	
</body>
</html>