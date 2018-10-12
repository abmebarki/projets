<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/menu.jsp"%>
		<s:actionmessage />
		<h2>
			Site
			<s:property value="site.nom" />
		</h2>
		<br /> Nom :
		<s:property value="site.nom" />
		<br /> Description :
		<s:property value="site.description" />
		<br /> Exposition :

		<s:iterator value="site.expositions" status="loop">
			<s:property value="value()" />
		</s:iterator>

		<br /> Temps d'approche :
		<s:property value="site.tempsApproche" />
		<br /> Saisons :
		<s:iterator value="site.saisons" status="loop">
			<s:property value="value()" />
		</s:iterator>
		<br /> Ville :
		<s:property value="site.ville" />
		<br /> Créateur :
		<s:property value="site.createur.nom" />
		<p>Liste des Secteurs</p>
		<s:iterator value="site.secteurs" status="loop">
			<div class="table-responsive-sm">
				<table class="table table-hover">
					<caption>
						Secteur
						<s:property value="%{#loop.index + 1}" />
					</caption>
					<thead class="thead-light">
						<tr>
							<th scope="col">Nom</th>
							<th scope="col">Description</th>
							<th scope="col">Type</th>
							<th scope="col">Difficulté</th>
							<th scope="col">Coordonnees</th>
							<th scope="col">Hauteur Max</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><s:property value="nom" /></td>
							<td><s:property value="description" /></td>
							<td><s:property value="type" /></td>
							<td><s:property value="difficulte" /></td>
							<td><s:property value="coordonnees" /></td>
							<td><s:property value="hauteurMax" /></td>
						</tr>
						<tr>
							<td colspan="7">
								<h4>Liste des voies</h4> <s:iterator value="voies" status="loop">
									<div class="table-responsive-sm">
										<table class="table table-hover">
											<caption>
												Voie
												<s:property value="%{#loop.index + 1}" />
											</caption>
											<thead class="thead-light">
												<tr>
													<th scope="col">Nom</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td><s:property value="nom" /></td>
												</tr>
												<tr>
													<td colspan="3">
														<h4>Liste des Longueurs</h4> <s:iterator value="longueurs" status="loop">
															<div class="table-responsive-sm">
																<table class="table table-hover">
																	<caption>
																		Longueur
																		<s:property value="%{#loop.index + 1}" />
																	</caption>
																	<thead class="thead-light">
																		<tr>
																			<th scope="col">Hauteur</th>
																			<th scope="col">Cotation</th>
																			<th scope="col">Nb Points</th>
																			<th scope="col">Equipée</th>
																		</tr>
																	</thead>
																	<tbody>
																		<tr>
																			<td><s:property value="hauteur" /></td>
																			<td><s:property value="cotation" /></td>
																			<td><s:property value="nbPoints" /></td>
																			<td><s:if test="equipee == true">
																Oui
															</s:if> <s:else>
																Non
															</s:else></td>
																		</tr>
																	</tbody>
																</table>
															</div>
														</s:iterator>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</s:iterator>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</s:iterator>
		<div class="table-responsive-sm">
			<table class="table table-hover">
				<caption>Liste des Topos</caption>
				<thead class="thead-light">
					<tr>
						<th scope="col">Nom</th>
						<th scope="col">Nb Pages</th>
						<th scope="col">Auteur</th>
						<th scope="col">Date</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="site.descripteurs" status="loop">
						<tr>
							<td><s:property value="nom" /></td>
							<td><s:property value="nbPages" /></td>
							<td><s:property value="auteur" /></td>
							<td><s:date name="date" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
		<div class="table-responsive-sm">
			<table class="table table-hover">
				<caption>Liste des Commentaires</caption>
				<s:a action="commentaire_site_new">
					<s:param name="siteId" value="site.id" />Ajouter commentaire</s:a>
				<thead class="thead-light">
					<tr>
						<th scope="col">Objet</th>
						<th scope="col">Contenu</th>
						<th scope="col">Date</th>
						<th scope="col">Nom Auteur</th>
						<th scope="col">Email Auteur</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="site.commentaires" status="loop">

						<tr>
							<td><s:property value="objet" /></td>
							<td><s:property value="contenu" /></td>
							<td><s:date name="date" /></td>
							<td><s:property value="auteur.nom" /></td>
							<td><s:property value="auteur.email" /></td>
							<s:if test="#session.user">
								<s:if test="#session.user.role.value() == 'ADMIN'">
									<td><s:a action="commentaire_site_update">
											<s:param name="id" value="id" />
											<s:param name="siteId" value="site.id" />Mettre à jour</s:a>&nbsp; <s:a action="commentaire_site_delete" onclick="return confirm('Voulez-vous vraiment supprimer?')">
											<s:param name="id" value="id" />
											<s:param name="siteId" value="site.id" />Supprimer</s:a>&nbsp;</td>
								</s:if>
							</s:if>
						</tr>

					</s:iterator>
				</tbody>
			</table>
		</div>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>