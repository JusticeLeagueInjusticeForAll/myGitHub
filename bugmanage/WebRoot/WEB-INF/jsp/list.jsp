<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>BUG管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script> 
	function add(){
	window.location.href="/bugmanage/adds?projectId="+pp.projectId.value;
} 
</script> 
  <body>
  <div align="center">
  
  	<form action="selDetail" method="post" name="pp">
  	
  		所属项目:
  		<select name="projectId">
  			<option value="">全部</option>
  			  <c:forEach items="${listP}" var="list">
  			  <option value="${list.id}"<c:if test='${list.id==id}'>selected = 'selected'</c:if>>${list.name }</option>
  			  </c:forEach>
  		</select>
  		<input  type="submit" value="查询"/>
  		<input  type="button" onclick="add()" value="新增BUG"/>
  		</form>
	   <table width="900" height="100" border="1">
	   <tr>
	   	<th colspan="5" align="center"><h1>BUG列表</h1></th>
	   </tr>
	   <tr style="background-color:#E93EFF;">
	    <th width="120" height="50px;" align="center">BUG编号</th>
	    <th width="120" height="50px;" align="center">严重性</th>
	    <th width="200" height="50px;" align="center">标题</th>
	    <th width="120" height="50px;" align="center">报告人</th>
	    <th width="200" height="50px;" align="center">报告时间</th>
	  </tr>
	  <c:forEach items="${listD}" var="list" varStatus="statu" >	      	
	      		<tr <c:if test="${statu.index%2==0}">bgcolor=#00FFFF;"</c:if>>
		     		  	<td align="center">${list.id}</td> 	
		     		  	<td align="center">${list.severity }</td> 
		     		  	<td align="center">${list.title}</td> 
		     		  	<td align="center">${list.reportUser}</td>
		     		  	<td align="center">${list.createDate}</td>	     		  	
		     	</tr>
      </c:forEach>
	  </table>
  	
  </div>  
  </body>
</html>
