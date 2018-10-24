<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="_include/header.jsp"%>
<link href="css/login.css" rel="stylesheet">
</head>

<body class="text-center">
	<div class="container">
		<%@ include file="_include/menu.jsp"%>
		<h2>&nbsp;</h2>
		<s:actionerror />
		<s:actionmessage />
		<s:form class="form-signin" action="login">
			<div class="form-group">
				<label for="login_email">Adresse email</label>
				<s:textfield name="email" label="Adresse email" class="form-control" placeholder="Adresse email" requiredLabel="true" required="true"/>
			</div>
			<div class="form-group">
				<label for="login_motpass">Mot de passe</label>
				<s:password name="motpasse" label="Mot de passe" class="form-control" placeholder="Mot de passe" requiredLabel="true" required="true"/>
			</div>
			<s:submit class="btn btn-lg btn-primary btn-block" value="Connexion" />
			
			<s:a action="grimpeur_new">Créer un compte</s:a><br>
			<s:a action="grimpeur_init_password">Mot de passe oublié ?</s:a>
			
		</s:form>
		<%@ include file="_include/footer.jsp"%>
	</div>
</body>
</html>
