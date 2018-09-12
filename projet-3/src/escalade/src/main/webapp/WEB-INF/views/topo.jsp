<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<title></title>
<body>
	<h2>Topo ${topo.nom}</h2>
	Id : ${topo.id}
	<br /> Nom : ${topo.nom}
	<br /> Nb Pages : ${topo.nbPages}
	<br /> Auteur : ${topo.auteur}
	<br /> Date : ${topo.date}
	<br /> Createur : ${topo.createur.nom}
	<br /> Proprietaire : ${topo.proprietaire.nom}
	
	<h3>Liste des Sites</h3>
	<c:forEach var="site" items="${topo.descriptibles}" varStatus="loop">
		<h4>Site ${loop.index + 1}</h4>
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
					<td>${site.id}</td>
					<td>${site.nom}</td>
					<td>${site.description}</td>
					<td>${site.nbSecteurs}</td>
					<td>${site.ville}</td>
				</tr>
			</tbody>
		</table>
	</c:forEach>
	
	<h3>Liste des Commentaires</h3>
	<c:forEach var="commentaire" items="${topo.commentaires}" varStatus="loop">
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