<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<c:set var="date" value="<%= new Random().nextInt() %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../include/stylescript.jsp"/>
<script type="text/javascript">
	
	// 장르검색 팝업
	var gnr;
	var ppl;
	
	
	function addGnrFn(message){
		console.log(message);
		
		var gnrItems = $("#addGnrBtn").closest(".create-group").find(".items");
		if(gnrItems.find("."+ message.gnrid).length > 0){
			gnr.alert(message.gnrnm + "은(는) 이미 추가된 장르입니다.");
			return;
		}
		
		var len = gnrItems.find(".gnr-item").length;
		var itemDiv = $("<div class='gnr-item " + message.gnrid + "'></div>");

		
		var itemId = $("<input type='hidden' name='gnrList["+ len+ "].gnrId' />");
		itemId.val(message.gnrid)
		itemDiv.append(itemId);
		
		
		var itemSpan = $("<span></span>");
		itemSpan.text(message.gnrnm);
		itemDiv.append(itemSpan);
		
		var itemRemoveBtn = $("<button>X</button>");
		itemRemoveBtn.click(function(){
			$(this).closest("."+ message.gnrid).remove();
			
		});
		itemDiv.append(itemRemoveBtn);
		
		gnrItems.append(itemDiv);
	}
	
	function addPplFn(message){
		console.log(message);
		
		var pplItems = $("#" +message.id).closest(".create-group").find(".items");
		if(pplItems.find("."+ message.mvpplid).length > 0){
			ppl.alert(message.nm + "은(는) 이미 추가된 영화인입니다.");
			return;
		}
		var len = $("#create_form").find(".mvppl-item").length;
		var itemDiv = $("<div class='mvppl-item " + message.mvpplid + "'></div>");

		
		var itemId = $("<input type='hidden' name='mvPplList["+ len+ "].mvPplId' />");
		itemId.val(message.mvpplid)
		itemDiv.append(itemId);
		
		var mssnId ="";
		
		if(message.id =="addDirectorBtn"){
			mssnId = "DRCTR" //감독
		}		
		else if(message.id =="addScripterBtn"){
			mssnId = "SCRPTR" //각본
		}
		
		else if(message.id =="addProducerBtn"){
			mssnId = "PRDCR" //연출
		}
		
		else if(message.id =="addMainActorBtn"){
			mssnId = "MNACTR" //주연
		}
		
		else if(message.id =="addSuppotingActorBtn"){
			mssnId = "SPRTACTR" //조연
		}
		
		else if(message.id =="addExtraBtn"){
			mssnId = "EXTR" //기타
		}
		
		var mssn = $("<input type='hidden' name='mvPplList["+ len+ "].mssn' placeholder ='임무' />");
		mssn.val(mssnId)
		itemDiv.append(mssn);
		
		var rspnsbltRolNm = $("<input type='text' name='mvPplList["+ len+ "].rspnsbltRolNm' placeholder ='역할명'/>");
		rspnsbltRolNm.val("")
		itemDiv.append(rspnsbltRolNm);		
		
		var itemSpan = $("<span></span>");
		itemSpan.text(message.nm);
		itemDiv.append(itemSpan);
		
		var itemRemoveBtn = $("<button>X</button>");
		itemRemoveBtn.click(function(){
			$(this).closest("."+ message.mvpplid).remove();
			
		});
		itemDiv.append(itemRemoveBtn);
		
		pplItems.append(itemDiv);
	}

	
	$().ready(function(){
		$("#addGnrBtn").click(function(){
			event.preventDefault();
			gnr = window.open("${context}/gnr/search","장르검색","width=500,height=500");
		});
		
		$("#addDirectorBtn, #addScripterBtn, #addProducerBtn, #addMainActorBtn, #addSuppotingActorBtn, #addExtraBtn").click(function(){
			event.preventDefault();
			ppl = window.open("${context}/mvppl/search?targetId=" + $(this).attr("id"),"영화인검색검색","width=500,height=500");
			
			var that = this;
			// /admin/mvppl/search 화면이 브라우저에 모두 로딩이 되었을 떄 ==> 랜더링이 끝났을 떄 // 다 열렸을 때 수행해라 
			ppl.onload = function(){
				//ppl.targetId = $(that).attr("id"); 
			}
		});
		
		
		$("#new_btn").click(function(){
			var ajaxUtil = new AjaxUtil();
			ajaxUtil.upload("#create_form","${context}/api/mv/create",function(response){
				if(response.status == "200 OK"){
					location.href= "${context}" + response.redirectURL;
				}
				else if(response.errorCode =="500") {
					alert(response.message);	
				}
				else{
					alert("영화 등록에 실패 했습니다.");
				}
			},{"pstr": "uploadFile"});
			
		});
		
		$(".profile").click(function(){
			$("#pstr").click();
			
		});
		
		$("#pstr").change(function(){
			//선택한 파일 정보
			var file = $(this)[0].files;
			console.log(file);
			
			if(file.length > 0){
				var fileReader = new FileReader();
				fileReader.onload = function(data){
					//FileReader 객체 로드가 완료 됐을 때.
					console.log(data);
					$(".profile").attr("src",data.target.result);
				}
				fileReader.readAsDataURL(file[0]);
				$("#isDeletePctr").val("Y");
				
			}
			else{
				//기본 이미지 변경
				$("#pstr").val("");
				$(".profile").attr("src", "${context}/img/baseProfile.png");
				$("#isDeletePctr").val("Y");
			}
	
			});
		
	});
</script>
</head>
<body>
	<div class="main-layout">
		<jsp:include page="../include/header.jsp"/>
		<div>
			<jsp:include page="../include/mvMgmtSidemenu.jsp"/>
			<jsp:include page="../include/content.jsp"/>
			   
				<div class="path"> 영화 > 영화관리 > 등록 </div>
			
				
				<h1>영화 정보 등록</h1>
				<div>
					<form id="create_form" enctype="multipart/form-data">
					
						<div class="create-group">
							<label for="pstr">포스터</label>
							<img class="profile" src="${context}/img/baseProfile.png" />
							<input type="file" id="pstr" name="pstr" />
						</div>
						
						<div class="create-group">
							<label for="mvTtl">영화제목</label>
							<input type="text" id="mvTtl" name="mvTtl" />
						</div>
						
						<div class="create-group">
							<label for="engTtl">영화제목(영어)</label>
							<input type="text" id="engTtl" name="engTtl" />
						</div>
						
						<div class="create-group">
							<label for="scrnStt">상영상태</label>
							<select id="scrnStt" name="scrnStt">
								<option>선택</option>
								<option value="상영중">상영중</option>
								<option value="상영예정">상영예정</option>
								<option value="상영종료">상영종료</option>
							</select>
						</div>
						
						<div class="create-group">
							<label for="scrnTm">상영시간(분)</label>
							<input type="number" id="scrnTm" name="scrnTm" value="0"/>
						</div>
						
						<div class="create-group">
							<label for="opngDt">개봉일</label>
							<input type="date" id="opngDt" name="opngDt" />
						</div>
						
						<div class="create-group">
							<label for="grd">관람등급</label>
							<select id="grd" name="grd">
								<option>선택</option>
								<option value="전체관람가">전체관람가</option>
								<option value="7">7세이상 관람가</option>
								<option value="12">12세이상 관람가</option>
								<option value="15">15세이상 관람가</option>
								<option value="19">청소년관람불가</option>		
							</select>
						</div>
						
						<div class="create-group">
							<label for="smr">줄거리</label>
							<textarea  id="smr" name="smr"></textarea>
						</div>
			
						
						<div class="create-group">
							<label for="useYn">게시여부</label>
							<input type="checkbox" id="useYn" name="useYn" value="Y" checked>
						</div>
	
						
						<div class="create-group">
							<label for="addGnrBtn">장르</label>
							<div>
								<button id="addGnrBtn" class="btn-primary">등록</button>
								<div class="items"></div>
							</div>
						</div>
						
						
						<div class="create-group">
							<label for="addDirectorBtn">감독</label>
							<div>
								<button id="addDirectorBtn" class="btn-primary">등록</button>
								<div class="items"></div>
							</div>
						</div>
						
						<div class="create-group">
							<label for="addScripterBtn">각본</label>
							<div>
								<button id="addScripterBtn" class="btn-primary">등록</button>
								<div class="items"></div>
							</div>
						</div>
						
						
						<div class="create-group">
							<label for="addProducerBtn">연출</label>
							<div>
								<button id="addProducerBtn" class="btn-primary">등록</button>
								<div class="items"></div>
							</div>	
						</div>
						<div class="create-group">
							<label for="addMainActorBtn">주연</label>
							<div>
								<button id="addMainActorBtn" class="btn-primary">등록</button>
								<div class="items"></div>
							</div>
						</div>
					
						
						<div class="create-group">
							<label for="addSuppotingActorBtn">조연</label>
							<div>
								<button id="addSuppotingActorBtn" class="btn-primary">등록</button>
								<div class="items"></div>
							</div>
						</div>
						
					
						<div class="create-group">
							<label for="addExtraBtn">기타</label>
							<div>
								<button id="addExtraBtn" class="btn-primary">등록</button>
								<div class="items"></div>
							</div>
						</div>
					</form>
				
				<div class="align-right">
					<button id="new_btn" class="btn-primary">등록</button>
					<button id="delete_btn" class="btn-delete">삭제</button>
				</div>
				
		
			<jsp:include page="../include/footer.jsp"/>
		</div>
	</div>
	</div>
</body>
</html>