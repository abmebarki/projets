<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title></title>
<body>
	<h2>Site ${site.nom}</h2>
	Id : ${site.id}
	<br /> Nom : ${site.nom}
	<br /> Description : ${site.description}
	<br /> Nb Secteurs : ${site.nbSecteurs}
	<br /> Ville : ${site.ville}
	<br /> Createur : ${site.createur.nom}
	

	<h3>Liste des Secteurs</h3>
	<c:forEach var="secteur" items="${site.secteurs}" varStatus="loop">
		<h4>Secteur ${loop.index + 1}</h4>
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
					<td>${secteur.id}</td>
					<td>${secteur.nom}</td>
					<td>${secteur.description}</td>
					<td>${secteur.nbVoies}</td>
					<td>${secteur.orientation}</td>
					<td>${secteur.coordonnees}</td>
					<td>${secteur.hauteurMax}</td>
				</tr>
				<tr>
					<td colspan="5">
						<h3>Liste des voies</h3> 
						<c:forEach var="voie" items="${secteur.voies}" varStatus="loop">
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
										<td>${voie.id}</td>
										<td>${voie.nom}</td>
										<td>${voie.nbLongueurs}</td>
									</tr>
									<tr>
										<td colspan="5">
											<h3>Liste des Longueurs</h3> 
											<c:forEach var="longueur" items="${voie.longueurs}" varStatus="loop">
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
															<td>${longueur.id}</td>
															<td>${longueur.hauteur}</td>
															<td>${longueur.cotation}</td>
															<td>${longueur.nbPoints}</td>
															<td>${longueur.equipee}</td>
														</tr>
													</tbody>
												</table>
											</c:forEach>
										</td> 
									</tr>
								</tbody>
							</table>
						</c:forEach>
					</td>
				</tr>
			</tbody>
		</table>
	</c:forEach>
	
	<h3>Liste des Topos</h3>
	<c:forEach var="topo" items="${site.descripteurs}" varStatus="loop">
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
					<td>${topo.id}</td>
					<td>${topo.nom}</td>
					<td>${topo.nbPages}</td>
					<td>${topo.auteur}</td>
					<td>${topo.date}</td>
				</tr>
			</tbody>
		</table>
	</c:forEach>
	
	<h3>Liste des Commentaires</h3>
	<c:forEach var="commentaire" items="${site.commentaires}" varStatus="loop">
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
					<td>${commentaire.id}</td>
					<td>${commentaire.objet}</td>
					<td>${commentaire.contenu}</td>
					<td>${commentaire.date}</td>
					<td>${commentaire.auteur.nom}</td>
					<td>${commentaire.auteur.email}</td>
				</tr>
			</tbody>
		</table>
	</c:forEach>
</body>
</html>