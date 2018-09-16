<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="_include/head.jsp"%>
</head>

<body>
<h2><s:text name="error.title" /></h2>

<s:actionerror />

<s:bean name="java.util.Date" var="now" />
<s:text name="error.metadata">
    <s:param value="now" />
</s:text>
</body>
</html>