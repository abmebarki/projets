<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>
<body><%@ include file="../_include/menu.jsp"%>
	<h2>Pret <s:property value="pret.nom"/></h2>
	Id : <s:property value="pret.id"/>
	<br /> Nom : <s:property value="pret.nom"/>
	<br /> Nb Pages : <s:property value="pret.nbPages"/>
	<br /> Auteur : <s:property value="pret.auteur"/>
	<br /> Date : <s:date name="pret.date"/>
	<br /> Createur : <s:property value="pret.createur.nom"/>
	<br /> Proprietaire : <s:property value="pret.proprietaire.nom"/>
	
	<h4>Liste des Sites</h4>
	<s:iterator value="pret.descriptibles" status="loop">
		<h4>Site <s:property value="%{#loop.index + 1}" /></h4>
		<table cellpadding="5" cellspacing="5">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Description</th>
					<th>Nb Secteurs</th>
					<th>Ville</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="nom" /></td>
					<td><s:property value="description" /></td>
					<td><s:property value="nbSecteurs" /></td>
					<td><s:property value="ville" /></td>
				</tr>
			</tbody>
		</table>
	</s:iterator>
	
	<h4>Liste des Commentaires&nbsp;<s:a action="commentaire_pret_new"><s:param name="pretId" value="pret.id" />Ajouter commentaire</s:a></h4>
	<s:iterator value="pret.commentaires" status="loop">
		<h4>Commentaire <s:property value="%{#loop.index + 1}" /></h4>
		<table cellpadding="5" cellspacing="5">
			<thead>
				<tr>
					<th>ID</th>
					<th>Objet</th>
					<th>Contenu</th>
					<th>Date</th>
					<th>Nom Auteur</th>
					<th>Email Auteur</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="objet" /></td>
					<td><s:property value="contenu" /></td>
					<td><s:date name="date" /></td>
					<td><s:property value="nom" /></td>
					<td><s:property value="auteur.email" /></td>
					<td>
						<s:a action="commentaire_pret_update"><s:param name="id" value="id" /><s:param name="pretId" value="pret.id" />Mettre à jour</s:a>&nbsp;
						<s:a action="commentaire_pret_delete" onclick="return confirm('Voulez-vous vraiment supprimer?')" ><s:param name="id" value="id" /><s:param name="pretId" value="pret.id" />Supprimer</s:a>&nbsp;
					</td>
				</tr>
			</tbody>
		</table>
	</s:iterator>
</body>
</html>