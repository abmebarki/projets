<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="_include/header.jsp"%>
</head>

<body><%@ include file="_include/menu.jsp"%>
    
    <h2>&nbsp;</h2>
    
    <s:actionerror />
	<s:actionmessage />

    <s:form action="login">
        <s:textfield name="email" label="Email" requiredLabel="true" />
        <s:password name="motpasse" label="Mot de passe" requiredLabel="true" />

        <s:submit value="Connexion"/>
    </s:form>
</body>
</html>