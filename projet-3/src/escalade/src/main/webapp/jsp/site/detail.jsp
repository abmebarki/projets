<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>

<body>
	<div class="container">
		<%@ include file="../_include/menu.jsp"%>
		<s:actionerror />
		<s:actionmessage />
		<s:form action="site_update">
			<s:hidden name="site.id"></s:hidden>
			<div class="row">
				<div class="col-6">
					<h3>Détail d'un site d'escalade</h3>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<label class="d-block">Nom</label>
					<s:property value="site.nom" />
				</div>
				<div class="col">
					<label class="d-block">Description</label>
					<s:property value="site.description" />
				</div>
				<div class="col">

					<label class="d-block">Expositions</label>
					<s:iterator value="site.expositions" status="loop">
						<s:property value="value()" />
					</s:iterator>

				</div>
			</div>
			<div class="row">

				<div class="col">
					<label class="d-block" for="site_update_site.tempsApproche">Temps d'approche en Minutes</label>
					<s:property value="site.tempsApproche" />
				</div>
				<div class="col">
					<label class="d-block">Saisons</label>
					<s:iterator value="site.saisons" status="loop">
						<s:property value="value()" />
					</s:iterator>
				</div>
				<div class="col">
					<label class="d-block">Ville</label>
					<s:property value="site.ville" />
				</div>
			</div>


			<div class="row">
				<div class="col-12">
					<div id="secteurs" class="clearfix">
						<s:iterator status="secteurStatus" value="site.secteurs">
							<div class="p-2 border border-primary secteur mr-1">
								<div class="row">
									<div class="col-12">
										<div class="row">
											<div class="col-12">
												<label class="font-weight-bold">Secteur&nbsp;<s:property value="%{#secteurStatus.index + 1}" /></label>
											</div>
										</div>
										<div class="row">
											<div class="col">

												<label class="d-block">Nom</label>
												<s:property value="nom"/>
											</div>
											<div class="col">

												<label class="d-block">Description</label>
												<s:property value="description"/>

											</div>
											<div class="col">

												<label class="d-block">Type</label>
												<s:property value="type"/>

											</div>
										</div>
										<div class="row">
											<div class="col">

												<label class="d-block">Difficulté</label>
												<s:property value="difficulte"/>

											</div>
											<div class="col">

												<label class="d-block">Coordonnees</label>
												<s:property value="coordonnees"/>

											</div>
											<div class="col">

												<label class="d-block">Hauteur Max</label>
												<s:property value="hauteurMax"/>

											</div>
										</div>

									</div>
								</div>




								<div class="row">
									<div class="col">
										<div class="row">
											<div class="col">
												<div id="voies" class="clearfix">
													<s:iterator status="voieStatus" value="voies">
														<div class="p-2 border border-success voie mr-1">

															<div class="row">
																<div class="col">
																	<label class="font-weight-bold">Voie <s:property value="%{#voieStatus.index + 1}" /></label> 
																	<label class="d-block">Nom</label>
																	<s:property value="nom"/>


																	<div id="longueurs" class="clearfix">
																		<s:iterator status="longueurStatus" value="longueurs">
																			<div class="float-left p-2 border border-danger mr-1 longueur">
																				<label class="font-weight-bold">Longueur&nbsp;<s:property value="%{#longueurStatus.index + 1}" /></label><br> 
																				<label>Hauteur</label>
																				<s:property value="hauteur"/><br>


																				<label>Cotation</label>
																				<s:property value="cotation"/><br>


																				<label>Nb Points</label>
																				<s:property value="nbPoints"/><br>


																				<label>Equipée</label>
																				<s:if test="equipee == true">
																					Oui
																				</s:if> <s:else>
																					Non
																				</s:else>

																			</div>
																		</s:iterator>
																	</div>
																</div>



															</div>



														</div>
													</s:iterator>


												</div>
											</div>
										</div>



									</div>
								</div>
							</div>
						</s:iterator>
					</div>
				</div>
			</div>
			<div class="row"></div>

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
						</tr>
					</thead>
					<tbody>
						<s:iterator value="site.commentaires" status="loop">

							<tr>
								<td><s:property value="objet" /></td>
								<td><s:property value="contenu" /></td>
								<td><s:date name="date" /></td>
								<td><s:property value="auteur.nom" /></td>
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

		</s:form>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>