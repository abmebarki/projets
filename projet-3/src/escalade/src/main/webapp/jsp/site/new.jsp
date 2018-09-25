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

	<h2>Création d'un site d'escalade</h2>
	
	<s:form action="site_new">

		<table>
			<tr><td>Site</td></tr>
			<tr><td><s:textfield name="site.nom" label="Nom" requiredLabel="true" /></td></tr>
			<tr><td><s:textfield name="site.description" label="Description" requiredLabel="true" /></td></tr>
			<tr><td><s:textfield name="site.nbSecteurs" label="Nb Secteurs"	requiredLabel="true"/></td></tr>
			<tr><td><s:textfield name="site.ville" label="Ville" requiredLabel="true" /></td></tr>
			
			<s:iterator status="secteurStatus" begin="1" end="2">
				<tr><td> Secteur <s:property value="%{#secteurStatus.index + 1}"/></td></tr>
				<tr><td><s:textfield name="site.secteurs[%{#secteurStatus.index}].nom" label="Nom" requiredLabel="true" /></td></tr>
				<tr><td><s:textfield name="site.secteurs[%{#secteurStatus.index}].description" label="Description" requiredLabel="true" /></td></tr>
				<tr><td><s:textfield name="site.secteurs[%{#secteurStatus.index}].nbVoies" label="Nb Voies" requiredLabel="true"/></td></tr>
				<tr><td><s:textfield name="site.secteurs[%{#secteurStatus.index}].orientation" label="Orientation" requiredLabel="true" /></td></tr>
				<tr><td><s:textfield name="site.secteurs[%{#secteurStatus.index}].coordonnees" label="Coordonnees" requiredLabel="true" /></td></tr>
				<tr><td><s:textfield name="site.secteurs[%{#secteurStatus.index}].hauteurMax" label="Hauteur Max" requiredLabel="true" /></td></tr>
				
				<s:iterator status="voiesStatus" begin="1" end="2" >
					<tr><td> Voie <s:property value="%{#voiesStatus.index + 1}"/></td></tr>
					<tr><td><s:textfield name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].nom" label="Nom" requiredLabel="true" /></td></tr>
					<tr><td><s:textfield name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].nbLongueurs" label="Nb Longueurs" requiredLabel="true"/></td></tr>
					
					<s:iterator status="longueursStatus" begin="1" end="2" >
						<tr><td> Longueur <s:property value="%{#LongueurStatus.index + 1}"/></td></tr>
						<tr><td><s:textfield name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].hauteur" label="hauteur" requiredLabel="true" /></td></tr>
						<tr><td><s:textfield name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].cotation" label="cotation" requiredLabel="true" /></td></tr>
						<tr><td><s:textfield name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].nbPoints" label="Nb Points" requiredLabel="true" /></td></tr>
						<tr><td><s:textfield name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].equipee" label="equipée" requiredLabel="true" /></td></tr>
					</s:iterator>
				</s:iterator>
			</s:iterator>
			
			<tr><td> Créateur</td></tr>
			<tr><td><s:textfield name="site.createur.nom" label="Nom" requiredLabel="true" /></td></tr>
			<tr><td><s:textfield name="site.createur.email" label="Email" requiredLabel="true" /></td></tr>
			
			
			<tr><td><s:submit value="OK" /></td></tr>
			
		</table>
		
	</s:form>
</body>
</html>