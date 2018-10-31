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
		<s:form class="form-signin" action="grimpeur_init_password">
			<legend>Initialisation du mot de passe d'un grimpeur</legend>
			<s:hidden name="grimpeur.id"></s:hidden>
			<div class="form-group">
				Nom : <s:property value="grimpeur.nom" />
			</div>
			<div class="form-group">
				Email :<s:property value="grimpeur.email" />
			</div>
			<div class="form-group">
				<label for="grimpeur_grimpeur_init_password_password">Mot de passe</label>
				<s:password class="form-control" name="grimpeur.motpasse" label="Mot de passe" placeholder="Mot de passe" requiredLabel="true" required="true"/>
			</div>
			<s:submit class="btn btn-lg btn-primary btn-block" value="OK" />
		</s:form>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>