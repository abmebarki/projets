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
		<s:form action="commentaire_site_update">
			<s:hidden name="siteId" />
			<s:hidden name="commentaire.id"></s:hidden>
			<legend>Création d'un site d'escalade</legend>
			<label>Commentaire</label>
			<div class="form-group">
				<label for="commentaire_site_new_commentaire_objet">Objet</label>
				<s:textfield class="form-control" name="commentaire.objet" label="Objet" requiredLabel="true" />
			</div>
			<div class="form-group">
				<label for="commentaire_site_new_commentaire_contenu">Contenu</label>
				<s:textfield class="form-control" name="commentaire.contenu" label="Contenu" requiredLabel="true" />
			</div>
			<div class="form-group">
				<label for="commentaire_site_new_commentaire_date">Date</label>
				<s:textfield class="form-control" name="commentaire.date" label="Date" requiredLabel="true" />
			</div>

			<s:submit class="btn btn-lg btn-primary btn-block" value="OK" />



		</s:form>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>