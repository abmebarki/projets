<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>
<body>
	<div class="container"><%@ include file="../_include/menu.jsp"%>
		<h2>
			Grimpeur
			<s:property value="grimpeur.nom" />
		</h2>
		<br /> Nom :
		<s:property value="grimpeur.nom" />
		<br /> Email :
		<s:property value="grimpeur.email" />
		<br /> Role :
		<s:property value="grimpeur.role" />
		<br /> Mot de passe :
		<s:property value="grimpeur.motpasse" />
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>