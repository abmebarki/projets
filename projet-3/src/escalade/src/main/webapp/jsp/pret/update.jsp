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
		<s:form action="pret_update">
			<s:hidden name="pret.id"></s:hidden>
			<legend>Mise à jour d'un prêt de topo</legend>
			<label>Prêt</label>
			<div class="form-group">
				<label for="pret_update_pret_dateDebut">Date début</label>
				<s:textfield class="form-control" name="pret.dateDebut" label="Date début" requiredLabel="true" />
			</div>
			<div class="form-group">
				<label for="pret_update_pret_dateFin">Date début</label>
				<s:textfield class="form-control" name="pret.dateFin" label="Date fin" requiredLabel="true" />
			</div>
			<s:submit class="btn btn-lg btn-primary btn-block" value="OK" />
		</s:form>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>