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
		<s:form action="topo_update">
			<s:hidden name="topo.id"></s:hidden>
			<legend>Mise à jour d'un topo d'escalade</legend>
			<div class="form-group">
				<label for="topo_update_topo_nom">Nom</label>
				<s:textfield class="form-control" name="topo.nom" label="Nom" requiredLabel="true" />
			</div>
			<div class="form-group">
				<label for="topo_update_topo_nbPages">Nb Pages</label>
				<s:textfield class="form-control" name="topo.nbPages" label="Nb Pages" requiredLabel="true" />
			</div>
			<div class="form-group">
				<label for="topo_update_topo_auteur">Auteur</label>
				<s:textfield class="form-control" name="topo.auteur" label="Auteur" requiredLabel="true" />
			</div>
			<div class="form-group">
				<label for="topo_update_topo_date">Date</label>
				<s:textfield class="form-control" name="topo.date" label="Date" requiredLabel="true" />
			</div>
			<s:submit class="btn btn-lg btn-primary btn-block" value="OK" />
		</s:form>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>