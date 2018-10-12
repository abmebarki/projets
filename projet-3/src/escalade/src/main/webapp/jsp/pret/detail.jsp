<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>
<body>
	<div class="container"><%@ include file="../_include/menu.jsp"%>
		<h2>Prêt</h2>
		<br /> Topo :
		<s:property value="pret.topoEmprunte.nom" />
		<br /> Emprunteur :
		<s:property value="pret.emprunteur.nom" />
		<br /> Date début :
		<s:date name="pret.dateDebut" />
		<br /> Date fin :
		<s:date name="pret.dateFin" />
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>