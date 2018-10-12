<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>

<body>
	<div class="container"><%@ include file="../_include/menu.jsp"%>
		<s:actionerror />
		<s:actionmessage />
		<s:form action="site_new">
			<legend>Création d'un site d'escalade</legend>
			<label>Site</label>
			<div class="form-group">
				<label for="site_new_site_nom">Nom</label>
				<s:textfield class="form-control" name="site.nom" label="Nom" requiredLabel="true" />
			</div>
			<div class="form-group">
				<label for="site_new_site_description">Description</label>
				<s:textfield class="form-control" name="site.description" label="Description" requiredLabel="true" />
			</div>
			<div class="form-group">
				<label for="site_new_site_expositions">Expositions</label>
				<s:checkboxlist class="checkbox-inline" label="Expositions" list="expositiontList" name="site.expositions" value="site.expositions" />
			</div>
			<div class="form-group">
				<label for="site_new_site.tempsApproche">Temps d'approche en Minutes</label>
				<s:textfield class="form-control" name="site.tempsApproche" label="Temps d'approche en Minutes" requiredLabel="true" />
			</div>
			<div class="form-group">
				<label for="site_new_site_saisons">Saisons</label>
				<s:checkboxlist class="checkbox-inline" label="Saisons" list="saisonList" name="site.saisons" value="site.saisons" />
			</div>
			<div class="form-group">
				<label for="site_new_site_ville">Ville</label>
				<s:textfield class="form-control" name="site.ville" label="Ville" requiredLabel="true" />
			</div>

			<s:iterator status="secteurStatus" begin="1" end="1">
				<label>Secteur</label>
				<s:property value="%{#secteurStatus.index + 1}" />
				<div class="form-group">
					<label>Nom</label>
					<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].nom" label="Nom" requiredLabel="true" />
				</div>
				<div class="form-group">
					<label>Description</label>
					<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].description" label="Description" requiredLabel="true" />
				</div>
				<div class="form-group">
					<label>Type</label>
					<s:select class="form-control" name="site.secteurs[%{#secteurStatus.index}].type" list="typeList" label="Type" emptyOption="true" requiredLabel="true" />
				</div>
				<div class="form-group">
					<label>Difficulté</label>
					<s:select class="form-control" name="site.secteurs[%{#secteurStatus.index}].difficulte" list="difficulteList" label="Difficulté" emptyOption="true" requiredLabel="true" />
				</div>
				<div class="form-group">
					<label>Coordonnees</label>
					<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].coordonnees" label="Coordonnees" requiredLabel="true" />
				</div>
				<div class="form-group">
					<label>Hauteur Max</label>
					<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].hauteurMax" label="Hauteur Max" requiredLabel="true" />
				</div>

				<s:iterator status="voiesStatus" begin="1" end="1">
					<label>Voie</label>
					<s:property value="%{#voiesStatus.index + 1}" />
					<div class="form-group">
						<label>Nom</label>
						<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].nom" label="Nom" requiredLabel="true" />
					</div>

					<s:iterator status="longueursStatus" begin="1" end="1">
						<label>Longueur</label>
						<s:property value="%{#longueursStatus.index + 1}" />
						<div class="form-group">
							<label>Hauteur</label>
							<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].hauteur" label="Hauteur" requiredLabel="true" />
						</div>
						<div class="form-group">
							<label>Cotation</label>
							<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].cotation" label="Cotation" requiredLabel="true" />
						</div>
						<div class="form-group">
							<label>Nb Points</label>
							<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].nbPoints" label="Nb Points" requiredLabel="true" />
						</div>
						<div class="form-group">
							<label>Equipée</label>
							<s:checkbox name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].equipee" label="Equipée" />
						</div>
					</s:iterator>

				</s:iterator>

			</s:iterator>

			<s:if test="#session.user">
				<s:hidden name="site.createur.id" value="%{session.user.id}"></s:hidden>
			</s:if>
			<div class="form-group">
				<label>Créer un nouveau topo</label>
				<s:checkbox label="Créer un nouveau topo" name="nouveauTopo" />
			</div>
			<s:if test="%{listTopo != null}">
				<div class="form-group">
					<label>Selectionner un topo</label>
					<s:select class="form-control" name="site.descripteurs.id" multiple="true" list="listTopo" listKey="id" listValue="nom" label="Selectionner un topo" emptyOption="true" requiredLabel="true" />
				</div>
			</s:if>

			<s:submit class="btn btn-lg btn-primary btn-block" value="OK" />
		</s:form>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>