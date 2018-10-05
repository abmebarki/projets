<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>
<body><%@ include file="../_include/menu.jsp"%>
	<h2>Prêt</h2>
	Id : <s:property value="pret.id"/>
	<br /> Topo : <s:property value="pret.topoEmprunte.id"/>
	<br /> Emprunteur : <s:property value="pret.emprunteur.id"/>
	<br /> Date début : <s:date name="pret.dateDebut"/>
	<br /> Date fin : <s:date name="pret.dateFin"/>
</body>
</html>