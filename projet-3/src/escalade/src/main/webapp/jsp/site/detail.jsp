<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>
<body><%@ include file="../_include/menu.jsp"%>

<s:actionmessage />

	<h2>
		Site
		<s:property value="site.nom" />
	</h2>
	ID :
	<s:property value="site.id" />
	<br /> Nom :
	<s:property value="site.nom" />
	<br /> Description :
	<s:property value="site.description" />
	<br /> Exposition :
	
	<s:iterator value="site.expositions" status="loop">
		<s:property value="value()"/>
	</s:iterator>
	
	<br /> Temps d'approche :
	<s:property value="site.tempsApproche" />
	<br /> Saisons :
	<s:iterator value="site.saisons" status="loop">
		<s:property value="value()"/>
	</s:iterator>
	<br /> Ville :
	<s:property value="site.ville" />
	<br /> Créateur :
	<s:property value="site.createur.nom" />

	<h4>Liste des Secteurs</h4>
	<s:iterator value="site.secteurs" status="loop">
		<h4>
			Secteur
			<s:property value="%{#loop.index + 1}" />
		</h4>
		<table cellpadding="5" cellspacing="5">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Description</th>
					<th>Type</th>
					<th>Difficulté</th>
					<th>Coordonnees</th>
					<th>Hauteur Max</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="nom" /></td>
					<td><s:property value="description" /></td>
					<td><s:property value="type" /></td>
					<td><s:property value="difficulte" /></td>
					<td><s:property value="coordonnees" /></td>
					<td><s:property value="hauteurMax" /></td>
				</tr>
				<tr>
					<td colspan="7">
						<h4>Liste des voies</h4> 
						<s:iterator value="voies" status="loop">
							<h4>Voie ${loop.index + 1}</h4>
							<table cellpadding="5" cellspacing="5">
								<thead>
									<tr>
										<th>ID</th>
										<th>Nom</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><s:property value="id" /></td>
										<td><s:property value="nom" /></td>
									</tr>
									<tr>
										<td colspan="3">
											<h4>Liste des Longueurs</h4> <s:iterator value="longueurs"
												status="loop">
												<h4>Longueur ${loop.index + 1}</h4>
												<table cellpadding="5" cellspacing="5">
													<thead>
														<tr>
															<th>ID</th>
															<th>Hauteur</th>
															<th>Cotation</th>
															<th>Nb Points</th>
															<th>Equipée</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td><s:property value="id" /></td>
															<td><s:property value="hauteur" /></td>
															<td><s:property value="cotation" /></td>
															<td><s:property value="nbPoints" /></td>
															<td><s:property value="equipee" /></td>
														</tr>
													</tbody>
												</table>
											</s:iterator>
										</td>
									</tr>
								</tbody>
							</table>
						</s:iterator>
					</td>
				</tr>
			</tbody>
		</table>
	</s:iterator>

	<h4>Liste des Topos</h4>
	<s:iterator value="site.descripteurs" status="loop">
		<h4>Topo ${loop.index + 1}</h4>
		<table cellpadding="5" cellspacing="5">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Nb Pages</th>
					<th>Auteur</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="nom" /></td>
					<td><s:property value="nbPages" /></td>
					<td><s:property value="auteur" /></td>
					<td><s:date name="date" /></td>
				</tr>
			</tbody>
		</table>
	</s:iterator>

	<h4>Liste des Commentaires&nbsp;<s:a action="commentaire_site_new"><s:param name="siteId" value="site.id" />Ajouter commentaire</s:a></h4>
	<s:iterator value="site.commentaires" status="loop">
		<h4>Commentaire ${loop.index + 1}</h4>
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
					<td><s:property value="auteur.nom" /></td>
					<td><s:property value="auteur.email" /></td>
					<s:if test="#session.user">
								<s:if test="#session.user.role == 'ADMIN'">
					<td>
					<s:a action="commentaire_site_update"><s:param name="id" value="id" /><s:param name="siteId" value="site.id" />Mettre à jour</s:a>&nbsp;
					<s:a action="commentaire_site_delete" onclick="return confirm('Voulez-vous vraiment supprimer?')" ><s:param name="id" value="id" /><s:param name="siteId" value="site.id" />Supprimer</s:a>&nbsp;
					</td>
					</s:if>
					</s:if>
				</tr>
			</tbody>
		</table>
	</s:iterator>
</body>
</html>