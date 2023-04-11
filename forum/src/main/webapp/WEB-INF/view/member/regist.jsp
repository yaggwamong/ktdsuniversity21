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
		
		$("#email").keyup(function() {
			// this = event가 발생한 객체
			var emailValue = $(this).val();
			emailValue = $.trim(emailValue);
			console.log(emailValue);
			
			// email을 쓰지 않았으면 요청 보내지 않기
			if (emailValue == "") {
				$("#dup_email").hide();
			}
			
			var url = "${pageContext.request.contextPath}/api/member/check/" + emailValue + "/";
			$.get(url, function(response) {
				console.log(response)
				if (response.email_count > 0) {
					$("#dup_email").show();
				}
				else {
					$("#dup_email").hide();
				}
				
			});
			
		});
		
		$("#submit_btn").click(function(event) {
			// submit 안 되게 막기
			event.preventDefault();
			
			// 이메일 입력 체크
			/* if ($.trim($("#email").val()) == "") {
				alert("이메일을 입력하세요!");
				$("#email").focus();
				return;
			}
			// 이름 입력 체크
			if ($.trim($("#name").val()) == "") {
				alert("이름을 입력하세요!");
				$("#name").focus();
				return;
			}
			// 비밀번호 입력 체크
			if ($.trim($("#password").val()) == "") {
				alert("비밀번호를 입력하세요!");
				$("#password").focus();
				return;
			}
			// 비밀번호 검증 입력 체크
			if ($.trim($("#passwordConfirm").val()) == "") {
				alert("비밀번호 검증을 입력하세요!");
				$("#passwordConfirm").focus();
				return;
			}
			// 비밀번호 일치 체크
			if ($.trim($("#password").val()) != $.trim($("#passwordConfirm").val())) {
				alert("비밀번호가 일치하지 않습니다!");
				return;
			} */
			
			var dup_email = $("#dup_email");
			var dupStatus = dup_email.css("display");
			
			// '이미 사용중인 이메일입니다'. 가 노출중인 경우는 아무 일도 하지 않는다
			if (dupStatus == "inline") {
				alert("이미 사용중인 이메일입니다! 다른 이메일을 입력하세요!");
			}
			// '이미 사용중인 이메일입니다.' 가 숨겨진 경우에만 등록을 진행한다.
			if (dupStatus == "none") {
				// 전송
				var url = "${pageContext.request.contextPath}/api/member/regist";
				// 폼 전체를 던질 때에는 중괄호는 쓰지 않는다
				$.post(url, $("#regist_form").serialize(), function(response) {
					console.log(response);
					if (response.registResult) {
						// 가입 성공 -> 로그인 페이지로 이동
						location.href = "${pageContext.request.contextPath}/member/login"
					}
					else if (response.status == "fail") {
						alert(response.message);
					}
					else {
						// response.registResult == false
						alert("시스템 오류입니다. 관리자에게 문의하세요.");
					}
				});
			}
		});
	});
</script>
</head>
<body>

	<h1>회원가입을 환영합니다!</h1>
	<!-- form : 서버로 여러가지 데이터들을 전송해주기 위한 태그 -->
	<!-- get - 데이터를 url에 넣어서 보낸다 (256글자 + @?) / post - 데이터를 body에 넣어서 보낸다 (4GB) -->
	<!-- input이 있다면 label은 반드시 존재해야 한다 -->
	<form id="regist_form">
		
		<div>
			<label for="email">이메일 : </label>
			<input type="email" name="email" id="email" 
			        maxlength="100" placeholder="EMAIL을 입력하세요." />
			<span id="dup_email" style="display:none;">이미 사용중인 이메일입니다!</span>
		</div>
		<div>
			<label for="name">이름 : </label>
			<input type="text" name="name" id="name" 
			        maxlength="10" placeholder="이름을 입력하세요." />
		</div>
		<div>
			<label for="password">비밀번호 : </label>
			<input type="password" name="password" id="password" 
			        maxlength="10" placeholder="비밀번호를 입력하세요." />
		</div>
		<div>
			<label for="password">비밀번호 검증 : </label>
			<input type="password" name="passwordConfirm" id="passwordConfirm" 
			        maxlength="10" placeholder="비밀번호를 한번 더 입력하세요." />
		</div>
		<div>
			<!-- <input type="submit" value="가입" /> -->
			<button id="submit_btn">가입</button>
		</div>
		
	</form>

</body>
</html>