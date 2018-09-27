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
	
	<s:form action="topo_new">

		<table>
			<tr><td>Topo</td></tr>
			<tr><td><s:textfield name="topo.nom" label="Nom" requiredLabel="true" /></td></tr>
			<tr><td><s:textfield name="topo.nbPages" label="Nb Pages" requiredLabel="true" /></td></tr>
			<tr><td><s:textfield name="topo.auteur" label="Auteur"	requiredLabel="true"/></td></tr>
			<tr><td><s:textfield name="topo.date" label="Date"	requiredLabel="true"/></td></tr>
			
			<tr><td> Créateur</td></tr>
			<tr><td><s:textfield name="topo.createur.nom" label="Nom" requiredLabel="true" /></td></tr>
			<tr><td><s:textfield name="topo.createur.email" label="Email" requiredLabel="true" /></td></tr>
			
			<tr><td> Proprietaire</td></tr>
			<tr><td><s:textfield name="topo.proprietaire.nom" label="Nom" requiredLabel="true" /></td></tr>
			<tr><td><s:textfield name="topo.proprietaire.email" label="Email" requiredLabel="true" /></td></tr>
			
			<tr>
				<td><s:if test="%{listSite != null}">
						<table cellpadding="5" cellspacing="5">
								<tr>
									<td>
									 	<s:select name="selectedSites" multiple="true" list="listSite" listKey="id"  listValue="nom" label="Selectionner un site"/>
									</td>
								</tr>
						</table>
					</s:if></td>
			</tr>
			
			
			<tr><td><s:submit value="OK" /></td></tr>
			
		</table>
		
	</s:form>
</body>
</html>