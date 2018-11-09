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


		<s:form action="commentaire_topo_new">
			<s:hidden name="topoId" />
			<legend>Création d'un commentaire</legend>
			<label>Commentaire</label>
			<div class="form-group">
				<label for="commentaire_topo_new_commentaire_objet">Objet</label>
				<s:textfield class="form-control" name="commentaire.objet" label="Objet" requiredLabel="true" required="true"/>
			</div>
			<div class="form-group">
				<label for="commentaire_topo_new_commentaire_contenu">Contenu</label>
				<s:textfield class="form-control" name="commentaire.contenu" label="Contenu" requiredLabel="true" required="true"/>
			</div>
			<s:if test="#session.user">
				<tr>
					<td><s:hidden name="commentaire.auteur.id" value="%{session.user.id}"></s:hidden>
				</tr>
			</s:if>

			<s:submit class="btn btn-lg btn-primary btn-block" value="OK" />



		</s:form>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>