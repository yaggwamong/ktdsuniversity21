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
	$().ready(function(){
		
		var ajaxUtil = new AjaxUtil();
		$(".grid > table > tbody > tr").click(function(){
			$(this).css("backgroundColor", "#53B6E8");
			$(this).siblings().css("backgroundColor", "");
			$("#isModify").val("true"); //수정모드
	
			var data =$(this).data(); 
			$("#mvPplId").val(data.mvpplid);
			//$("#prflpctr").val(data.prflpctr);
			$("#nm").val(data.nm);
			$("#rlNm").val(data.rlnm);
			$("#crtDt").val(data.crtdt);
			$("#crtr").val(data.crtr + "(" +data.crtrnm + ")" );
			$("#mdfyDt").val(data.mdfydt);
			$("#mdfyr").val(data.mdfyr + "(" +data.mdfyrnm + ")" );

			$("#previewPrfl").attr("src", "${context}/mvppl/prfl/"+ data.prflpctr +"/");
			$("#useYn").prop("checked",data.useyn =="Y");
		});

		$("#new_btn").click(function(){
			$("#isModify").val("false"); //등록모드
			
			$("#mvPplId").val("");
			//$("#prflpctr").val("");
			$("#nm").val("");
			$("#rlNm").val("");
			$("#crtDt").val("");
			$("#crtr").val("");
			$("#mdfyDt").val("");
			$("#mdfyr").val("");
			$("#previewPrfl").attr("src", "${context}/img/baseProfile.png");
			$("#useYn").prop("checked",false);
		});
		
		
		$("#delete_btn").click(function(){
			var gnrId = $("#gnrId").val();
			if(gnrId==""){
				alert("선택된 영화인이 없습니다.");
				return;
			}
			if(!confirm("정말 삭제하시겠습니까?")){
				return;
			}
			$.get("${context}/api/mvppl/delete/" +gnrId, function(response){
				if(response.status =="200 OK"){
					location.reload(); //새로고침	
				}
				else{
					alert(response.errorCode + "/" + response.message);
				}
			})
		});
		

			
			
/* 		$("#all_check").click(function() {
			$(".check_idx").prop("checked",$("#all_check").is(":checked"));
			
		}); */
		
		
		
		
		$("#save_btn").click(function(){
			
			if( $("#isModify").val() =="false"){
				//신규등록
				ajaxUtil.upload("#detail_form","${context}/api/mvppl/create",function(response){
					if(response.status =="200 OK"){
						location.reload(); //새로고침			
					}
					else {
						alert(response.errorCode + "/" + response.message);
					}
				}, {"prflPctr": "uploadFile"});
				
				
		    }
			else{ 
				//수정
				ajaxUtil.upload("#detail_form", "${context}/api/mvppl/update", function(response){
					if(response.status =="200 OK"){
						location.reload(); //새로고침	
					}
					else {
						alert(response.errorCode + "/" + response.message);
					}
				}, {"prflPctr": "uploadFile"});
			}

		});
		
		$("#search-btn").click(function(){
			movePage(0);
		});
		
		
		
	 /* 	$("#all_check").click(function() {
			movePage(0);	
		});  */
	 	
		$("#all_check").change(function() {
			//console.log($(this.prop("checked"));
			$(".check_idx").prop("checked",$(this).prop("checked"));
		});
			
		$(".check_idx").change(function(){
			var count = $(".check_idx").length;
			var checkCount =$(".check_idx:checked").length;
			console.log(count,checkCount)
			$("#all_check").prop("checked",count==checkCount);
		});
		
		$("#delete_all_btn").click(function(){
			var checkLen= $(".check_idx:checked").length;
			if(checkLen ==0){
				alert("삭제할 장르가 없습니다.");
				return;
			}
			if(!confirm("정말 삭제하시겠습니까?")){
				return;
			}
			var form =$("<form></form>")	
			
			$(".check_idx:checked").each(function(){
				console.log($(this).val());
				form.append("<input type='hidden' name='mvPplId' value='" + $(this).val() + "'>")
			});

			$.post("${context}/api/mvppl/delete",form.serialize(),function(response){
				if(response.status =="200 OK"){
					location.reload(); //새로고침	
				}
				else {
					alert(response.errorCode + "/" + response.message);
				}
			});
		});
			
			$("#previewPrfl").click(function(){
				$("#prflPctr").click();
			});
			$("#prflPctr").change(function(){
				//선택한 파일 정보
				var file = $(this)[0].files;
				console.log(file);
				
				if(file.length > 0){
					var fileReader = new FileReader();
					fileReader.onload = function(data){
						//FileReader 객체 로드가 완료 됐을 때.
						console.log(data);
						$("#previewPrfl").attr("src",data.target.result);
					}
					fileReader.readAsDataURL(file[0]);
					$("#isDeletePctr").val("Y");
					
				}
				else{
					//기본 이미지 변경
					$("#prflPctr").val("");
					$("#previewPrfl").attr("src", "${context}/img/baseProfile.png");
					$("#isDeletePctr").val("Y");
				}
		
				});
			
			$("#del_pctr").click(function(event){
				event.preventDefault();
				$("#prflPctr").val("");
				$("#previewPrfl").attr("src", "${context}/img/baseProfile.png");
				$("#isDeletePctr").val("Y");
				console.log(isDeletePctr);
				
				
			})
	});
		
	function movePage(pageNo){
		//전송.
		//입력 값.	
		var nm = $("#search-keyword-nm").val();
		var rlNm = $("#search-keyword-rlnm").val();
		var startDt = $("#search-keyword-startdt").val();
		var endDt = $("#search-keyword-enddt").val();
		
		var intStartDt = parseInt(startDt.split("-").join(""));
		var intEndDt = parseInt(endDt.split("-").join(""));
		console.log(intStartDt);
		console.log(intEndDt);
		
		if(intStartDt > intEndDt){
			alert("시작일자를 확인해 주세요.");
			return;
		}
		
		
		var queryString = "nm=" + nm;
		queryString += "&rlNm=" +rlNm;
		queryString += "&startDt=" +startDt;
		queryString += "&endDt=" +endDt;
		queryString += "&pageNo=" +pageNo;
		//URL 요청
		location.href = "${context}/mvppl/list?" + queryString;
	}
</script>
</head>
<body>
	<div class="main-layout">
		<jsp:include page="../include/header.jsp"/>
		<div>
			<jsp:include page="../include/mvMgmtSidemenu.jsp"/>
			<jsp:include page="../include/content.jsp"/>
			   
				<div class="path"> 영화 > 영화인관리 </div>
				
				<div class="search-row-group">
					<div class="search-group">
						<label for="search-keyword-nm">이름</label>
						<input type="text" id="search-keyword-nm" 
							   class="search-input" value="${mvPplVO.nm}"/>
						
						<label for="search-keyword-rlnm">본명</label>
						<input type="text" id="search-keyword-rlnm"
							   class="search-input" value="${mvPplVO.rlNm}"/>
					</div>
					
					<div class="search-group">
						<label for="search-keyword-startdt">조회기간</label>
						<input type="date" id="search-keyword-startdt" 
							   class="search-input" value="${mvPplVO.startDt}"/>
						<input type="date" id="search-keyword-enddt"
							   class="search-input" value="${mvPplVO.endDt}"/>

						<button class="btn-search" id="search-btn">검색</button>
					</div>
				</div>
				
				
				<div class="grid">
					<div class="grid-count align-right">
						총 ${mvPplList.size() > 0 ? mvPplList.get(0).totalCount : 0}건
					</div>
					<table>
						<thead>
							<tr>
								<th><input type = "checkbox" id ="all_check"/></th>

								<th>영화인ID</th>
								<th>프로필사진</th>
								<th>이름</th>
								<th>본명</th>
								<th>등록자</th>
								<th>등록일</th>
								<th>수정자</th>
								<th>수정일</th>
								
								
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty mvPplList}">
									<c:forEach items="${mvPplList}"
											   var="mvPpl" >
										<tr data-mvpplid="${mvPpl.mvPplId}"  
										    data-prflpctr="${mvPpl.prflPctr}" 
										    data-nm="${mvPpl.nm}"
										    data-rlnm="${mvPpl.rlNm}"					
										    data-crtdt="${mvPpl.crtDt}" 
										    data-crtr="${mvPpl.crtr}" 				    
										    data-mdfydt="${mvPpl.mdfyDt}"
										    data-mdfyr="${mvPpl.mdfyr}"
										    data-useyn="${mvPpl.useYn}"
										    data-crtrnm="${mvPpl.crtrMbrVO.mbrNm}"
										    data-mdfyrnm="${mvPpl.mdfyrMbrVO.mbrNm}" 
										    > 
										    
											<td>
												<input type ="checkbox" class="check_idx" value="${mvPpl.mvPplId}">
											</td>
											<td>${mvPpl.mvPplId}</td>
											<td>${mvPpl.prflPctr}</td>
											<td>${mvPpl.nm}</td>
											<td>${mvPpl.rlNm}</td>
											<td>${mvPpl.crtr}(${mvPpl.crtrMbrVO.mbrNm})</td>
											<td>${mvPpl.crtDt}</td>
											<td>${mvPpl.mdfyr}(${mvPpl.mdfyrMbrVO.mbrNm})</td>
											<td>${mvPpl.mdfyDt}</td>		
										</tr>
										<tr>
								
											
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="8" class="no-items">
										등록된 영화인이 없습니다.
										</td>
									
									</tr>
								</c:otherwise>
							</c:choose>
						
						</tbody>
					</table>
					<div class="align-right mt-10">
						<button id="delete_all_btn" class="btn-delete">삭제</button>
					</div>
					<div class="pagenate">
						<ul>
							<c:set value = "${mvPplList.size() > 0 ? mvPplList.get(0).lastPage : 0}" var="lastPage"/>
							<c:set value = "${mvPplList.size() > 0 ? mvPplList.get(0).lastPage : 0}" var="lastGroup"/>
							
							<fmt:parseNumber var="nowGroup" value="${Math.floor(gnrVO.pageNo /10)}" integerOnly="true" />
							<c:set value ="${nowGroup*10}" var="groupStartPageNo" />
							<c:set value ="${nowGroup*10+ 10}" var="groupEndPageNo" />
							<c:set value ="${groupEndPageNo > lastPage ? lastPage :groupEndPageNo-1}" var="groupEndPageNo" />
							
							<c:set value ="${(nowGroup - 1) * 10}" var="prevGroupStartPageNo" />  
							<c:set value ="${(nowGroup + 1) * 10}" var="nextGroupStartPageNo" />
							
					<%-- 		lastPage: ${lastPage} 
							lastGroup:${lastGroup}
							nowGroup:${nowGroup}
							groupStartPageNo:${groupStartPageNo}
							groupEndPageNo:${groupEndPageNo}
							prevGroupStartPageNo:${prevGroupStartPageNo}
							nextGroupStartPageNo: ${nextGroupStartPageNo} --%>
				
							<c:if test="${nowGroup > 0}">
								<li><a href="javascript:movePage(0)">처음</a></li>
								<li><a href="javascript:movePage(${prevGroupStartPageNo})")>이전</a></li>
							</c:if>
									
							<c:forEach begin="${groupStartPageNo}" end="${groupEndPageNo}" step="1" var="pageNo">
								<li><a class="${pageNo eq gnrVO.pageNo ? 'on' : ''}" href="javascript:movePage(${pageNo})">${pageNo+1}</a></li>
							</c:forEach>
							
							<c:if test="${lastGroup > nowGroup}">
								<li><a href="javascript:movePage(${nextGroupStartPageNo})">다음</a></li>
								<li><a href="javascript:movePage(${lastPage})">끝</a></li>
							</c:if>
						</ul>
					</div>
					
				</div>
				
				<div class="grid-detail" >
					<form id="detail_form" enctype ="multipart/form-data">
						<!-- 
						isModify ==true => 수정(update)
						isModify == false => 등록(insert)
						 -->
						<input type="hidden" id="isModify" value="false" />
						<div class="input-group inline">
							<label for="mvPplId" style=" width:180px;">영화인ID</label><input type="text" id="mvPplId" name="mvPplId" readonly value=""/>
						</div>	
						<div class="input-group inline">
							<div style="position: relative;">
								<label for="prflPctr" style=" width:180px;">프로필사진</label>
								<input type="file" id="prflPctr"  name="prflPctr" value="" style="display:none;"/>
								<img src="${context}/img/baseProfile.png" id="previewPrfl" class="profile" />
								<button id="del_pctr" style="position:absolute; right: 10px; bottom: 10px;">X</button>
								<input type="hidden" id="isDeletePctr" name="isDeletePctr" value="N"/>
							</div>
							
						</div>	
						<div class="input-group inline">
							<label for="nm" style=" width:180px;">이름</label>
							<input type="text" id="nm" name="nm" value=""/>
						</div>		
						<div class="input-group inline">
							<label for="rlNm" style=" width:180px;">본명</label><input type="text" id="rlNm" name="rlNm"  value=""/>
						</div>
						<div class="input-group inline">
							<label for="crtr" style=" width:180px;">등록자</label><input type="text" id="crtr"  disabled value=""/>
						</div>
						<div class="input-group inline">
							<label for="crtDt" style=" width:180px;">등록일</label><input type="text" id="crtDt" disabled value=""/>
						</div>	
						<div class="input-group inline">
							<label for="mdfyr" style=" width:180px;">수정자</label><input type="text" id="mdfyr"  disabled value=""/>
						</div>
						<div class="input-group inline">
							<label for="mdfyDt" style=" width:180px;">수정일</label><input type="text" id="mdfyDt" disabled value=""/>
						</div>
						<div class="input-group inline">
							<label for="useYn" style=" width:180px;">사용여부</label><input type="checkbox" id="useYn" value="Y"/>
						</div>
						
							
					</form>
					
					
				</div>
				<div class="align-right">
					<button id="new_btn" class="btn-primary">신규</button>
					<button id="save_btn" class="btn-primary">저장</button>
					<button id="delete_btn" class="btn-delete">삭제</button>
				</div>
				
				
				
				
				
			<jsp:include page="../include/footer.jsp"/>
		</div>
	</div>
</body>
</html>