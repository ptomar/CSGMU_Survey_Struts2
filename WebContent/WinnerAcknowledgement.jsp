<!-- This is a JSP page which dispalyed when mean of data is more than 90  -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import=" java.util.*"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WinnerAcknowledgement</title>
</head>
<body bgcolor="violet">
<div align="center">
<h1>Thank you very much for your time in providing this valuable survey !!</h1>
<h2 style="color: blue">Congratulations!!! You won two movie tickets!!!!!!</h2>
		<h3>The Mean for the values you entered is:<s:property value= "Mean" /></h3>
		<h3>The Standard Deviation is: <s:property value= "SD" /></h3>
		<p> Your Data has been saved successfully</p><br/>
<h4>Here is the list of id's which we have in our database. Please click on any and see the details fo that student:</h4>

	</div>	
	<table align="center">	
	
	<ul>
		<s:iterator value="sidList">
		<tr>	
			<td><li><a href="/CSGMU_Survey_Struts2/popstudent?id=<s:property/>"><s:property></s:property></a></li></td>
			</tr>
			</s:iterator>
		
	</ul>
		</table>

</body>
</html>