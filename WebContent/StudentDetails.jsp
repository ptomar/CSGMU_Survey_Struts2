<!--This is a JSP page for student details  -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import=" java.util.*"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
</head>
<body bgcolor="violet">
<div align="center">
<h2>Here are the details for the id which you have selected: </h2></div>
<table align="center" border="1">
<tr><td><b style="color: blue;">Name: </b><s:property value="studentBean.getName()" /></td> 
<td><b style="color: blue;">Id: </b><s:property value="studentBean.getId()" /></td>
<td><b style="color: blue;">Address: </b><s:property value="studentBean.getAddress()" /></td></tr>

<tr><td><b style="color: blue;">Zip: </b><s:property value="studentBean.getZip()" /></td>
<td><b style="color: blue;">City: </b><s:property value="studentBean.getCity()" /></td>
<td><b style="color: blue;">State: </b><s:property value="studentBean.getState()" /></td></tr>


<tr><td><b style="color: blue;">Telephone: </b><s:property value="studentBean.getCellphone()" /></td>
<td><b style="color: blue;">E-mail: </b><s:property value="studentBean.getEmail()" /></td>
<td><b style="color: blue;">URL: </b><s:property value="studentBean.getURL()" /></td></tr>

<tr><td><b style="color: blue;">Date Of Survey: </b><s:property value="studentBean.getDate()" /></td>
<td><b style="color: blue;">Liked about campus: </b><s:property value="studentBean.getCamp()" /></td>
<td><b style="color: blue;">University Interest: </b><s:property value="studentBean.getUniversity()" /></td></tr>

<tr><td><b style="color: blue;">Comments: </b><s:property value="studentBean.getComments()" /></td>
<td><b style="color: blue;">Grad month: </b><s:property value="studentBean.getMonth()" /></td>
<td><b style="color: blue;">Grad year: </b><s:property value="studentBean.getYear()" /></td></tr>

<tr><td><b style="color: blue;">Recommendation: </b><s:property value="studentBean.getRecommend()" /></td></tr>
</table>

</body>
</html>