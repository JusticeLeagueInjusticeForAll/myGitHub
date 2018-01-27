<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  	function check()
    {
        if((add.title.value==""))
        {
           alert('BUG标题不能为空');
           add.title.value="";
           add.title.focus();
           return false;
         }
         return true;
     }
     
     function rd(){
     	window.location.href="/bugmanage/selDetail";
     }
  </script>
  <body>
    <form action="addBug" name="add" method="post" onsubmit="return check()">
    	<table width="600px;"  border="1">
    		<tr >
    		<th colspan="2" width="100%" align="center" style="background-color: gray;padding-top: 20px"><h1>增加BUG</h1></th>
    		</tr>
    		<tr>
    			<td width="15%">所属项目</td>
    			<td width="80%">
  		<select name="projectId">
  			<option value="">全部</option>
  			  <c:forEach items="${listP}" var="list">
  			  <option value="${list.id }"  <c:if test='${list.id==id}'>selected = 'selected'</c:if>>${list.name }</option>
  			  </c:forEach>
  		</select></td>
    		</tr>
    		
    		
    		<tr>
    		<td width="15%">严重性</td>
    		<td width="80%">
  		<select name="severity">
  			<option value="10">文字错误</option>
  			<option value="20">次要错误</option>
  			<option value="30">严重错误</option>
  		</select></td>
    		</tr>
    		<tr>
    		<td width="15%">BUG标题(*)</td>
    		<td width="80%">
  				<input type="text" name="title"/>
  			</td>
    		</tr>
    		<tr>
    			<td width="15%">报告人</td>
    		<td width="80%">
  				<input type="text" name="reportUser"/>
  			</td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
    				<input type="submit" value="提交"/>
    				
    				<input type="button" onclick="rd()" value="返回"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
