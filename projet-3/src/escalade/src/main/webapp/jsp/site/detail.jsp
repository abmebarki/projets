<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<title></title>
<body>

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
	<br /> Nb Secteurs :
	<s:property value="site.nbSecteurs" />
	<br /> Ville :
	<s:property value="site.ville" />
	<br /> Créateur :
	<s:property value="site.createur.nom" />

	<h3>Liste des Secteurs</h3>
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
					<th>Nb Voies</th>
					<th>Orientation</th>
					<th>Coordonnees</th>
					<th>Hauteur Max</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="nom" /></td>
					<td><s:property value="description" /></td>
					<td><s:property value="nbVoies" /></td>
					<td><s:property value="orientation" /></td>
					<td><s:property value="coordonnees" /></td>
					<td><s:property value="hauteurMax" /></td>
				</tr>
				<tr>
					<td colspan="5">
						<h3>Liste des voies</h3> <s:iterator value="voies" status="loop">
							<h4>Voie ${loop.index + 1}</h4>
							<table cellpadding="5" cellspacing="5">
								<thead>
									<tr>
										<th>ID</th>
										<th>Nom</th>
										<th>Nb Longueurs</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><s:property value="id" /></td>
										<td><s:property value="nom" /></td>
										<td><s:property value="nbLongueurs" /></td>
									</tr>
									<tr>
										<td colspan="5">
											<h3>Liste des Longueurs</h3> <s:iterator value="longueurs"
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

	<h3>Liste des Topos</h3>
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

	<h3>Liste des Commentaires</h3>
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
				</tr>
			</tbody>
		</table>
	</s:iterator>
</body>
</html>