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

		<s:form action="site_update">
			<s:hidden name="site.id"></s:hidden>
			<legend>Mise à jour d'un site d'escalade</legend>
			<label>Site</label>
			<div class="form-group">
				<label for="site_update_site_nom">Nom</label>
				<s:textfield class="form-control" name="site.nom" label="Nom" requiredLabel="true" required="true"/>
			</div>
			<div class="form-group">
				<label for="site_update_site_description">Description</label>
				<s:textfield class="form-control" name="site.description" label="Description" requiredLabel="true" required="true"/>
			</div>
			<div class="form-group">
				<label for="site_update_site_expositions">Expositions</label>
				<s:checkboxlist label="Expositions" list="expositiontList" name="site.expositions" value="site.expositions" />
			</div>
			<div class="form-group">
				<label for="site_update_site_tampsApproche">Temps d'approche</label>
				<s:textfield class="form-control" name="site.tempsApproche" label="Temps d'approche" requiredLabel="true" required="true"/>
			</div>
			<div class="form-group">
				<label for="site_update_site_saisons">Saisons</label>
				<s:checkboxlist label="Saisons" list="saisonList" name="site.saisons" value="site.saisons" />
			</div>
			<div class="form-group">
				<label for="site_update_site_ville">Ville</label>
				<s:textfield class="form-control" name="site.ville" label="Ville" requiredLabel="true" required="true"/>
			</div>

			<s:iterator status="secteurStatus" begin="1" end="1">
				<s:hidden name="site.secteurs[%{#secteurStatus.index}].id"></s:hidden>
				<label>Secteur</label>
				<s:property value="%{#secteurStatus.index + 1}" />
				<div class="form-group">
					<label>Nom</label>
					<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].nom" label="Nom" requiredLabel="true" required="true"/>
				</div>
				<div class="form-group">
					<label>Description</label>
					<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].description" label="Description" requiredLabel="true" required="true"/>
				</div>
				<div class="form-group">
					<label>Type</label>
					<s:select name="site.secteurs[%{#secteurStatus.index}].type" list="typeList" label="Type" emptyOption="true" requiredLabel="true" required="true"/>
				</div>
				<div class="form-group">
					<label>Difficulté</label>
					<s:select name="site.secteurs[%{#secteurStatus.index}].difficulte" list="difficulteList" label="Difficulté" emptyOption="true" requiredLabel="true" required="true"/>
				</div>
				<div class="form-group">
					<label>Coordonnees</label>
					<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].coordonnees" label="Coordonnees" requiredLabel="true" required="true"/>
				</div>
				<div class="form-group">
					<label>Hauteur Max</label>
					<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].hauteurMax" label="Hauteur Max" requiredLabel="true" required="true"/>
				</div>
				<s:iterator status="voiesStatus" begin="1" end="1">
					<s:hidden name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].id"></s:hidden>
					<label>Voie</label>
					<s:property value="%{#voiesStatus.index + 1}" />
					<div class="form-group">
						<label>Nom</label>
						<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].nom" label="Nom" requiredLabel="true" required="true"/>
					</div>
					<s:iterator status="longueursStatus" begin="1" end="1">
						<s:hidden name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].id"></s:hidden>
						<label>Longueur</label>
						<s:property value="%{#LongueurStatus.index + 1}" />
						<div class="form-group">
							<label>Hauteur</label>
							<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].hauteur" label="Hauteur" requiredLabel="true" required="true"/>
						</div>
						<div class="form-group">
							<label>Cotation</label>
							<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].cotation" label="Cotation" requiredLabel="true" required="true"/>
						</div>
						<div class="form-group">
							<label>Nb Points</label>
							<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].nbPoints" label="Nb Points" requiredLabel="true" required="true"/>
						</div>
						<div class="form-group">
							<label>Nb Points</label>
							<s:checkbox name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].equipee" label="equipée" />
						</div>
					</s:iterator>
				</s:iterator>
			</s:iterator>
			<s:submit class="btn btn-lg btn-primary btn-block" value="OK" />
		</s:form>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>