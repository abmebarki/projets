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
					<div class="form-group">
						<label for="site_update_site_nom">Nom</label>
						<s:textfield class="form-control" name="site.nom" label="Nom" requiredLabel="true" required="true" disabled="true"/>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="site_update_site_description">Description</label>
						<s:textfield class="form-control" name="site.description" label="Description" requiredLabel="true" required="true" disabled="true"/>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="site_update_site_expositions" class="d-block">Expositions</label>
						<s:checkboxlist class="checkbox-inline" label="Expositions" list="expositiontList" name="site.expositions" value="site.expositions" disabled="true"/>
					</div>
				</div>
			</div>
			<div class="row">

				<div class="col">
					<div class="form-group">
						<label for="site_update_site.tempsApproche">Temps d'approche en Minutes</label>
						<s:textfield class="form-control" name="site.tempsApproche" label="Temps d'approche en Minutes" requiredLabel="true" required="true" disabled="true"/>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="site_update_site_saisons" class="d-block">Saisons</label>
						<s:checkboxlist class="checkbox-inline" label="Saisons" list="saisonList" name="site.saisons" value="site.saisons" disabled="true"/>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="site_update_site_ville">Ville</label>
						<s:textfield class="form-control" name="site.ville" label="Ville" requiredLabel="true" required="true" disabled="true"/>
					</div>
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
											<label class="font-weight-bold">Secteur <s:property value="%{#secteurStatus.index} + 1}" /></label>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<div class="form-group">
												<label>Nom</label>
												<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].nom" label="Nom" requiredLabel="true" required="true" disabled="true"/>
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>Description</label>
												<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].description" label="Description" requiredLabel="true" required="true" disabled="true"/>
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>Type</label>
												<s:select class="form-control" name="site.secteurs[%{#secteurStatus.index}].type" list="typeList" label="Type" emptyOption="true" requiredLabel="true" required="true" disabled="true"/>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<div class="form-group">
												<label>Difficulté</label>
												<s:select class="form-control" name="site.secteurs[%{#secteurStatus.index}].difficulte" list="difficulteList" label="Difficulté" emptyOption="true" requiredLabel="true" required="true" disabled="true"/>
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>Coordonnees</label>
												<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].coordonnees" label="Coordonnees" requiredLabel="true" required="true" disabled="true"/>
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>Hauteur Max</label>
												<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].hauteurMax" label="Hauteur Max" requiredLabel="true" required="true" disabled="true"/>
											</div>
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
															<label class="font-weight-bold">Voie <s:property value="%{#voieStatus.index} + 1}" /></label>
															<div class="form-group">
																<label>Nom</label>
																<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voieStatus.index}].nom" label="Nom" requiredLabel="true" required="true" disabled="true"/>
															</div>
															
															<div id="longueurs" class="clearfix">
																<s:iterator status="longueurStatus" value="longueurs">
																<div class="float-left p-2 border border-danger mr-1 longueur">
																	<label class="font-weight-bold">Longueur <s:property value="%{#longueurStatus.index} + 1}" /></label>
																	
																	<div class="form-group">
																		<label>Hauteur</label>
																		<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voieStatus.index}].longueurs[%{#longueurStatus.index}].hauteur" label="Hauteur" requiredLabel="true" required="true" disabled="true"/>
																	</div>
																	<div class="form-group">
																		<label>Cotation</label>
																		<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voieStatus.index}].longueurs[%{#longueurStatus.index}].cotation" label="Cotation" requiredLabel="true" required="true" disabled="true"/>
																	</div>
																	<div class="form-group">
																		<label>Nb Points</label>
																		<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voieStatus.index}].longueurs[%{#longueurStatus.index}].nbPoints" label="Nb Points" requiredLabel="true" required="true" disabled="true"/>
																	</div>
																	<div class="form-group">
																		<label>Equipée</label>
																		<s:checkbox name="site.secteurs[%{#secteurStatus.index}].voies[%{#voieStatus.index}].longueurs[%{#longueurStatus.index}].equipee" label="Equipée" disabled="true" />
																	</div>
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
			<div class="row">
			</div>
			
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

		</s:form>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>