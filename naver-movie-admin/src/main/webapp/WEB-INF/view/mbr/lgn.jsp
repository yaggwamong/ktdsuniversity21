<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="${context}/css/common.css"/>
<script type="text/javascript" src="${context}/js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
		
		$("#login_btn").click(function(){
			
			var data={
					mbrId:$("#mbrId").val(),
					pwd:$("#pwd").val()
			};
			$.post("${context}/api/mbr/lgn",data,function(response){
				//Response Spec
/* 				{
					status: "200 OK",
					message:"",
					errorCode:"",
					redirectURL:""
				} */
				console.log(response);
				
				if(response.status=="200 OK"){
					if(response.redirectURL){
						location.href="${context}"+response.redirectURL;
					}			
				}
				else if (response.status =="400"){
					//파라미터를 전달하지 않은 경우
					alert(response.message);
				}
				else{
					alert(response.errorCode +" / "+response.message);
					if(response.redirectURL){
						location.href="${context}" + response.redirectURL
					}
				}
			})
		});	
		
		const signInBtn = document.getElementById("signIn");
		const signUpBtn = document.getElementById("signUp");
		const fistForm = document.getElementById("form1");
		const secondForm = document.getElementById("form2");
		const container = document.querySelector(".container");

		signInBtn.addEventListener("click", () => {
		  container.classList.remove("right-panel-active");
		});

		signUpBtn.addEventListener("click", () => {
		  container.classList.add("right-panel-active");
		});

		fistForm.addEventListener("submit", (e) => e.preventDefault());
		secondForm.addEventListener("submit", (e) => e.preventDefault());
	});
</script>
<style type="text/css">
:root {
  /* COLORS */
  --white: #e9e9e9;
  --gray: #333;
  --blue: #0367a6;
  --lightblue: #008997;

  /* RADII */
  --button-radius: 0.7rem;

  /* SIZES */
  --max-width: 758px;
  --max-height: 420px;

  font-size: 16px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}

body {
  align-items: center;
  background-color: var(--white);
  background: url("https://g-selected.pstatic.net/MjAyMzAyMjNfMTE2/MDAxNjc3MTE3NTExMTkw.i5-SPCUZwYSfys9Bbf40hwkRkvkCEVJSL1kJGmLV7CEg.BL2Mapq79LZs3S50IkWkOl5WdnyJ9A_FszA8LXMRrO8g.JPEG/image.jpg?type=w1440_q80");
  background-attachment: fixed;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  display: grid;
  height: 100vh;
  place-items: center;
}

.form__title {
  font-weight: 700;
  margin: 0;
  margin-bottom: 1.25rem;
}

  .main_image {
    position: relative;
  }
  .main_image_text {
    position: absolute;
    font-weight: 100;
    font-family: fantasy;
    top: 20%;
    left: 50%;
    transform: translate( -50%, -50% );
    color: white;
  }

.link {
  color: var(--gray);
  font-size: 0.9rem;
  margin: 1.5rem 0;
  text-decoration: none;
}

.container {
  background-color: var(--white);
  border-radius: var(--button-radius);
  box-shadow: 0 0.9rem 1.7rem rgba(0, 0, 0, 0.25),
    0 0.7rem 0.7rem rgba(0, 0, 0, 0.22);
  height: var(--max-height);
  max-width: var(--max-width);
  overflow: hidden;
  position: relative;
  width: 100%;
}

.container__form {
  height: 100%;
  position: absolute;
  top: 0;
  transition: all 0.6s ease-in-out;
}

.container--signin {
  left: 0;
  width: 50%;
  z-index: 2;
}

.container.right-panel-active .container--signin {
  transform: translateX(100%);
}

.container--signup {
  left: 0;
  opacity: 0;
  width: 50%;
  z-index: 1;
}

.container.right-panel-active .container--signup {
  animation: show 0.6s;
  opacity: 1;
  transform: translateX(100%);
  z-index: 5;
}

.container__overlay {
  height: 100%;
  left: 50%;
  overflow: hidden;
  position: absolute;
  top: 0;
  transition: transform 0.6s ease-in-out;
  width: 50%;
  z-index: 100;
}

.container.right-panel-active .container__overlay {
  transform: translateX(-100%);
}

.overlay {
  background-color: var(--lightblue);
  background: url("https://img1.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/202302/21/xportsnews/20230221064508295ikss.jpg");
  background-attachment: fixed;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 100%;
  left: -100%;
  position: relative;
  transform: translateX(0);
  transition: transform 0.6s ease-in-out;
  width: 200%;
}

.container.right-panel-active .overlay {
  transform: translateX(50%);
}

.overlay__panel {
  align-items: center;
  display: flex;
  flex-direction: column;
  height: 100%;
  justify-content: center;
  position: absolute;
  text-align: center;
  top: 0;
  transform: translateX(0);
  transition: transform 0.6s ease-in-out;
  width: 50%;
}

.overlay--left {
  transform: translateX(-20%);
}

.container.right-panel-active .overlay--left {
  transform: translateX(0);
}

.overlay--right {
  right: 0;
  transform: translateX(0);
}

.container.right-panel-active .overlay--right {
  transform: translateX(20%);
}

.btn {
  background-color: var(--blue);
  background-image: linear-gradient(90deg, var(--blue) 0%, var(--lightblue) 74%);
  border-radius: 20px;
  border: 1px solid var(--blue);
  color: var(--white);
  cursor: pointer;
  font-size: 0.8rem;
  font-weight: bold;
  letter-spacing: 0.1rem;
  padding: 0.9rem 4rem;
  text-transform: uppercase;
  transition: transform 80ms ease-in;
}

.form > .btn {
  margin-top: 1.5rem;
}

.btn:active {
  transform: scale(0.95);
}

.btn:focus {
  outline: none;
}

.form {
  background-color: var(--white);
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  padding: 0 3rem;
  height: 100%;
  text-align: center;
}

.input {
  background-color: #fff;
  border: none;
  padding: 0.9rem 0.9rem;
  margin: 0.5rem 0;
  width: 100%;
}

@keyframes show {
  0%,
  49.99% {
    opacity: 0;
    z-index: 1;
  }

  50%,
  100% {
    opacity: 1;
    z-index: 5;
  }
}

</style>
</head>

<body>
  
  
  <div class="container right-panel-active">
  
  
    <!-- Sign In -->
  <div class="container__form container--signin">
    <form action="#" class="form" id="form2">
      <h2 class="form__title">Sign In</h2>
	  <input type="text" id="mbrId" placeholder="ID" name="mbrId" class="input"/>
      <input type="password" id="pwd" placeholder="Password" name="pwd" class="input"/>
      <a href="#" class="link">Forgot your password?</a>
      <button class="btn" id="login_btn">Sign In</button>
    </form>
  </div>
  
  <!-- Sign Up -->
  <div class="container__form container--signup">
    <form action="#" class="form" id="form1">
	<div class="main_image">
      <img src="https://cdn.imweb.me/upload/S202207061bf15be9dabe3/46c35636b0f57.jpg" >


    <h2 class="main_image_text" style="font-size:50px">Admin</h2>

</div>
  </div>

	  <!-- Overlay -->
	  <div class="container__overlay">
	    <div class="overlay">
	      <div class="overlay__panel overlay--left">
	        <button class="btn" id="signIn">Sign In</button>
	      </div>
	      <div class="overlay__panel overlay--right">
	        <button class="btn" id="signUp">Admin</button>
	      </div>
	    </div>
	  </div>
  </div>

</div>

</body>
</html>