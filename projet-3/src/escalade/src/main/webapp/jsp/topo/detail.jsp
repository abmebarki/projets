<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>
<body>
	<div class="container"><%@ include file="../_include/menu.jsp"%>
		<h2>
			Topo
			<s:property value="topo.nom" />
		</h2>
		<br /> Nom :
		<s:property value="topo.nom" />
		<br /> Nb Pages :
		<s:property value="topo.nbPages" />
		<br /> Auteur :
		<s:property value="topo.auteur" />
		<br /> Date :
		<s:date name="topo.date" />
		<br /> Proprietaire :
		<s:property value="topo.proprietaire.nom" />
		<div class="table-responsive-sm">
			<table class="table table-hover">
				<caption>Liste des sites</caption>
				<thead class="thead-light">
					<tr>
						<th scope="col">Nom</th>
						<th scope="col">Description</th>
						<th scope="col">Ville</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="topo.descriptibles" status="loop">
						<tr>
							<td><s:property value="nom" /></td>
							<td><s:property value="description" /></td>
							<td><s:property value="ville" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>

		<p>
			<s:a action="commentaire_topo_new">
				<s:param name="topoId" value="topo.id" />Ajouter commentaire</s:a>
		</p>
		<div class="table-responsive-sm">
			<table class="table table-hover">
				<caption>Liste des Commentaires</caption>
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

					<s:iterator value="topo.commentaires" status="loop">

						<tr>
							<td><s:property value="objet" /></td>
							<td><s:property value="contenu" /></td>
							<td><s:date name="date" /></td>
							<td><s:property value="nom" /></td>
							<td><s:property value="auteur.email" /></td>
							<s:if test="#session.user">
								<s:if test="#session.user.role.value() == 'ADMIN'">
									<td><s:a action="commentaire_topo_update">
											<s:param name="id" value="id" />
											<s:param name="topoId" value="topo.id" />Mettre à jour</s:a>&nbsp; <s:a action="commentaire_topo_delete" onclick="return confirm('Voulez-vous vraiment supprimer?')">
											<s:param name="id" value="id" />
											<s:param name="topoId" value="topo.id" />Supprimer</s:a>&nbsp;</td>
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