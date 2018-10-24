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
		<s:form action="grimpeur_new">
			<legend>Création d'un grimpeur</legend>
			<div class="form-group">
				<label for="grimpeur_new_grimpeur_nom">Nom</label>
				<s:textfield class="form-control" name="grimpeur.nom" label="Nom" requiredLabel="true" required="true"/>
			</div>
			<div class="form-group">
				<label for="grimpeur_new_grimpeur_email">Email</label>
				<s:textfield class="form-control" name="grimpeur.email" label="Email" requiredLabel="true" required="true"/>
			</div>
			
			<s:if test="#session.user and #session.user.role.value() == 'ADMIN'">
				<div class="form-group">
				<label for="grimpeur_new_grimpeur_role">Role</label>
				<s:select class="form-control" name="grimpeur.role" list="roleList" label="Selectionner un role" emptyOption="true" requiredLabel="true"/>
			</div>
			
			</s:if>
			
			<div class="form-group">
				<label for="grimpeur_new_grimpeur_motpasse">Mot de passe</label>
				<s:textfield class="form-control" name="grimpeur.motpasse" label="Mot de passe" requiredLabel="true" required="true"/>
			</div>
			<s:submit class="btn btn-lg btn-primary btn-block" value="OK" />
		</s:form>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>