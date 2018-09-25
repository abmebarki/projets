<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>

<body><%@ include file="../_include/menu.jsp"%>
	<s:actionerror />
	<s:actionmessage />

	<h2>Création d'un topo d'escalade</h2>
	
	<s:form action="commentaire_topo_update">
		<s:hidden name="topoId"/>
		<s:hidden name="commentaire.id"></s:hidden>
		<table>
			<tr><td>Commentaire</td></tr>
			<tr><td><s:textfield name="commentaire.objet" label="Objet" requiredLabel="true" /></td></tr>
			<tr><td><s:textfield name="commentaire.contenu" label="Contenu" requiredLabel="true" /></td></tr>
			<tr><td><s:textfield name="commentaire.date" label="Date"	requiredLabel="true"/></td></tr>
			
			<tr><td><s:submit value="OK"/></td></tr>
			
		</table>
		
	</s:form>
</body>
</html>