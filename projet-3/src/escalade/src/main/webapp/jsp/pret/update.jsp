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

	<h2>Création d'un prêt de topo</h2>
	
	<s:form action="pret_new">

		<table>
			<tr><td>Prêt</td></tr>
			<tr><td><s:textfield name="pret.id" label="Id" requiredLabel="true" /></td></tr>
			<tr><td><s:textfield name="pret.topoEmprunte.id" label="Topo emprunté" requiredLabel="true" /></td></tr>
			<tr><td><s:textfield name="pret.emrunteur.id" label="Emprunteur"	requiredLabel="true"/></td></tr>
			<tr><td><s:textfield name="pret.dateDebut" label="Date début"	requiredLabel="true"/></td></tr>
			<tr><td><s:textfield name="pret.dateFin" label="Date fin"	requiredLabel="true"/></td></tr>
			
			<tr><td><s:submit value="OK" /></td></tr>
			
		</table>
		
	</s:form>
</body>
</html>