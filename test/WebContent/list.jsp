<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
</head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>


$(function(){
	
	
	$(".paging").click(function(){
		var pageno = $(this).attr('id')
		console.log(pageno);
		$.ajax({
			url:'selectAll.do',
            method: 'GET', 
            data:{
            	'pageno': pageno
			},
            success:function(responseData){
            	
            	$("article").empty();
                $("article").html(responseData.trim()); 
          }
        });  // end ajax
		return false; 
		
	});
	
	

	
});



</script>

<style>

</style>

<body topmargin="0" leftmargin="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td height="25"><img src="image/icon.gif" width="9" height="9" align="absmiddle"> 
      <strong>사원조회</strong></td>
  </tr>
  <tr> 
    <td><table width="640" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td height="30" align="right"><select name="select" class="INPUT">
              <option selected>::::: 전체 :::::</option>
            </select> <input name="textfield" type="text" class="INPUT"> <a href="#"><img src="image/search.gif" width="49" height="18" border="0" align="absmiddle"></a></td>
        </tr>
        <tr> 
          <td><table width="640" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td height="3" background="image/bar_bg1.gif"></td>
              </tr>
              <tr align="center" bgcolor="F8F8F8"> 
                <td height="26" align="right" bgcolor="F8F8F8" style="padding-right:10"><img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">수정</a> <img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">인사기록카드</a> <img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">경력정보</a> <img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">근무정보</a> </td>
              </tr>
              <tr align="center" bgcolor="F8F8F8"> 
                <td height="1" align="right" bgcolor="B1B1B1"></td>
              </tr>
              <tr> 
                <td>
				<!-------------------------  리스트 ------------------------------>
				<table width="640" border="0" cellspacing="0" cellpadding="0">
				
				<c:set var="list" value="${requestScope.list}"/>
				<c:set var="listSize"  value="${requestScope.listSize}"/> 
				<c:forEach var="ismater"  items="${list}" >
				
				
					<tr> 
                      <td width="35" height="20" align="center"><input type="checkbox" name="checkbox" value="checkbox"></td>
                      <td width="85" align="center">${ismater.korName}</td>
                      <td width="153" align="center">${ismater.juminNo}</td>
                      <td width="91" align="center">${ismater.sex}</td>
                      <td width="91" align="center">${ismater.workDate}</td>
                      <td width="91" align="center">${ismater.workFlag}</td>
                      <td width="94" align="center">${ismater.techLev}</td>
                    </tr>
                    
                    <tr> 
                      <td colspan="7" background="image/line_bg.gif"></td>
                    </tr>
				
				
				</c:forEach>
                    
                    <tr> 
                      <td height="35" colspan="7" align="center" style="padding-bottom:3">
                      
						 
                    <%!
						public Integer toInt(String x){
							int a = 0;
							try{
								a = Integer.parseInt(x);
							}catch(Exception e){}
							return a;
						}
					%>
					<%
						int pageno = toInt(request.getParameter("pageno"));
						if(pageno<1){//현재 페이지
							pageno = 1;
						}
						
						/* 전체리스트 길이 구해오기 시작 */
						Integer objTotal_record = (Integer)request.getAttribute("listSize");
						/* int total_record =23;
						if(objTotal_record==null){
							total_record=10;
						}else{ */
						int total_record=objTotal_record;
						/* } */
						System.out.println("objTotal_record" + objTotal_record);
						/* 전체리스트 길이 구해오기 끝 */
						
						
						int page_per_record_cnt = 10;  //페이지 당 레코드 수
						int group_per_page_cnt =5;     //페이지 당 보여줄 번호 수[1],[2],[3],[4],[5]
						int record_end_no = pageno*page_per_record_cnt;				
						int record_start_no = record_end_no-(page_per_record_cnt-1);
						if(record_end_no>total_record){
							record_end_no = total_record;
						}
															   
															   
						int total_page = total_record / page_per_record_cnt + (total_record % page_per_record_cnt>0 ? 1 : 0);
						if(pageno>total_page){
							pageno = total_page;
						}
					
						
					
					// 	현재 페이지(정수) / 한페이지 당 보여줄 페지 번호 수(정수) + (그룹 번호는 현제 페이지(정수) % 한페이지 당 보여줄 페지 번호 수(정수)>0 ? 1 : 0)
						int group_no = pageno/group_per_page_cnt+( pageno%group_per_page_cnt>0 ? 1:0);
					//		현재 그룹번호 = 현재페이지 / 페이지당 보여줄 번호수 (현재 페이지 % 페이지당 보여줄 번호 수 >0 ? 1:0)	
					//	ex) 	14		=	13(몫)		=	 (66 / 5)		1	(1(나머지) =66 % 5)			  
						
						int page_eno = group_no*group_per_page_cnt;		
					//		현재 그룹 끝 번호 = 현재 그룹번호 * 페이지당 보여줄 번호 
					//	ex) 	70		=	14	*	5
						int page_sno = page_eno-(group_per_page_cnt-1);	
					// 		현재 그룹 시작 번호 = 현재 그룹 끝 번호 - (페이지당 보여줄 번호 수 -1)
					//	ex) 	66	=	70 - 	4 (5 -1)
						
						if(page_eno>total_page){
					//	   현재 그룹 끝 번호가 전체페이지 수 보다 클 경우		
							page_eno=total_page;
					//	   현재 그룹 끝 번호와 = 전체페이지 수를 같게
						}
						
						int prev_pageno = page_sno-group_per_page_cnt;  // <<  *[이전]* [21],[22],[23]... [30] [다음]  >>
					//		이전 페이지 번호	= 현재 그룹 시작 번호 - 페이지당 보여줄 번호수	
					//	ex)		46		=	51 - 5				
						int next_pageno = page_sno+group_per_page_cnt;	// <<  [이전] [21],[22],[23]... [30] *[다음]*  >>
					//		다음 페이지 번호 = 현재 그룹 시작 번호 + 페이지당 보여줄 번호수
					//	ex)		56		=	51 - 5
						if(prev_pageno<1){
					//		이전 페이지 번호가 1보다 작을 경우		
							prev_pageno=1;
					//		이전 페이지를 1로
						}
						if(next_pageno>total_page){
					//		다음 페이지보다 전체페이지 수보가 클경우		
							next_pageno=total_page/group_per_page_cnt*group_per_page_cnt+1;
					//		next_pageno=total_page
					//		다음 페이지 = 전체페이지수 / 페이지당 보여줄 번호수 * 페이지당 보여줄 번호수 + 1 
					//	ex)			   = 	76 / 5 * 5 + 1	???????? 		
						}
						
						// [1][2][3].[10]
						// [11][12]
					%>
					현재 페이지   (pageno)   : <%=pageno%><br />
					전체 데이터 수   (total_record) : <%=total_record %><br />
					한페이지 당 레코드 수   (page_per_record_cnt) : <%=page_per_record_cnt %><br />
					한페이지 당 보여줄 페지 번호 수   (group_per_page_cnt) : <%=group_per_page_cnt %><br />
					
					<hr />
					레코드 시작 번호  (record_start_no) : <%=record_start_no%><br />
					레코드 끝 번호    (record_end_no) : <%=record_end_no %><br />
					전체페이지 수     (total_page)  : <%=total_page %><br />
					<hr />
					현재 그룹번호 [1] (group_no):  <%=group_no %><br />
					현재 그룹 시작 번호(page_sno): <%= page_sno%><br />
					현재 그룹 끝 번호  (page_eno): <%= page_eno%><br />
					이전 페이지 번호   (prev_pageno) <%=prev_pageno%><br />
					다음 페이지 번호   (next_pageno) <%=next_pageno%><br />
					<hr />
					
					
				<a href=""><img src="image/prev.gif" width="22" height="15" border="0" align="absmiddle"></a>&nbsp;
					
                <a href=""><img src="image/pre.gif" width="42" height="15" border="0" align="absmiddle"></a>&nbsp; 
                                            
                        <a href="" class="prev">[이전]</a> 
					
					<%for(int i =page_sno;i<=page_eno;i++){%>
						<a href="" class="paging" id="<%=i%>">
							<%if(pageno == i){ %>
								[<%=i %>]
							<%}else{ %>
								<%=i %>
							<%} %>
						</a> 
					<%--	콤마	 --%>	
						<%if(i<page_eno){ %>
							|
						<%} %>
					<%} %>
					 
					<a href="" class="next">[다음]</a> &nbsp;
                        
                        
                  <a href=""><img src="image/next.gif" width="42" height="15" border="0" align="absmiddle"></a>&nbsp
                        
				  <a href=""><img src="image/next_.gif" width="22" height="15" border="0" align="absmiddle"></a>
					
					
					
					
					<!-- <a href="selectAll.do?pageno=1">[맨앞으로]</a> -->
					<%-- <a href="selectAll.do?pageno=<%=prev_pageno%>">[이전]</a> 
					
					<%for(int i =page_sno;i<=page_eno;i++){%>
						<a href="selectAll.do?pageno=<%=i %>">
							<%if(pageno == i){ %>
								[<%=i %>]
							<%}else{ %>
								<%=i %>
							<%} %>
						</a> 
						콤마		
						<%if(i<page_eno){ %>
							|
						<%} %>
					<%} %>
					 
					<a href="selectAll.do?pageno=<%=next_pageno%>" >[다음]</a> --%>
					<%-- <a href="selectAll.do?pageno=<%=total_page %>">[맨뒤로]</a> --%>
                    
                    </td>
                    
                    </tr>
                  </table>
 				<!-------------------------  리스트 ------------------------------>
				  </td>
              </tr>
              <tr align="center" bgcolor="F8F8F8"> 
                <td height="1" align="right" bgcolor="B1B1B1"></td>
              </tr>
              <tr align="center" bgcolor="F8F8F8"> 
                <td height="26" align="right" bgcolor="F8F8F8" style="padding-right:10"><img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">수정</a> <img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">인사기록카드</a> <img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">경력정보</a> <img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">근무정보</a> </td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td height="3" background="image/bar_bg1.gif"></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>

</html>
