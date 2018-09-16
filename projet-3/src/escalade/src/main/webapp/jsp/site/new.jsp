<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
</head>

<body>
	<s:actionerror />
	<s:actionmessage />

	<h2>Création d'un site d'escalade</h2>

	<s:form action="site_new">
		<h3>
			<s:label>Site</s:label>
		</h3>
		<s:textfield name="site.nom" label="Nom" requiredLabel="true" />
		<s:textfield name="site.description" label="Description"
			requiredLabel="true" />
		<s:textfield name="site.nbSecteurs" label="Nb Secteurs"
			requiredLabel="true" />
		<s:textfield name="site.ville" label="Ville" requiredLabel="true" />

		<h3>
			<s:label>Secteur 1</s:label>
		</h3>
		<s:textfield name="site.secteurs[0].nom" label="Nom"
			requiredLabel="true" />
		<s:textfield name="site.secteurs[0].description" label="Description"
			requiredLabel="true" />
		<s:textfield name="site.secteurs[0].nbVoies" label="Nb Voies"
			requiredLabel="true" />
		<s:textfield name="site.secteurs[0].orientation" label="Orientation"
			requiredLabel="true" />
		<s:textfield name="site.secteurs[0].coordonnees" label="Coordonnees"
			requiredLabel="true" />
		<s:textfield name="site.secteurs[0].hauteurMax" label="Hauteur Max"
			requiredLabel="true" />

		<h3>
			<s:label>Secteur 2</s:label>
		</h3>
		<s:textfield name="site.secteurs[1].nom" label="Nom"
			requiredLabel="true" />
		<s:textfield name="site.secteurs[1].description" label="Description"
			requiredLabel="true" />
		<s:textfield name="site.secteurs[1].nbVoies" label="Nb Voies"
			requiredLabel="true" />
		<s:textfield name="site.secteurs[1].orientation" label="Orientation"
			requiredLabel="true" />
		<s:textfield name="site.secteurs[1].coordonnees" label="Coordonnees"
			requiredLabel="true" />
		<s:textfield name="site.secteurs[1].hauteurMax" label="Hauteur Max"
			requiredLabel="true" />



		<s:submit value="OK" />
	</s:form>
</body>
</html>