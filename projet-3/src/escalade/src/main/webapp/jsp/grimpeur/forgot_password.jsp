<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
<link href="css/login.css" rel="stylesheet">
</head>

<body>
	<div class="container"><%@ include file="../_include/menu.jsp"%>
		<s:actionerror />
		<s:actionmessage />
		<s:form class="form-signin" action="grimpeur_forgot_password">
			<legend>Initialisation du mot de passe d'un grimpeur</legend>
			<div class="form-group">
				<label for="grimpeur_new_grimpeur_email">Nom</label>
				<s:textfield class="form-control" name="grimpeur.nom" label="Nom" placeholder="Nom" requiredLabel="true" required="true"/>
			</div>
			<div class="form-group">
				<label for="grimpeur_new_grimpeur_email">Email</label>
				<s:textfield class="form-control" name="grimpeur.email" label="Email" placeholder="Email" requiredLabel="true" required="true"/>
			</div>
			<s:submit class="btn btn-lg btn-primary btn-block" value="OK" />
		</s:form>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>