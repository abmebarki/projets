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
		<s:form action="pret_new">
			<legend>Création d'un prêt de topo</legend>
			<label>Prêt</label>
			<s:if test="%{listTopo != null}">
				<div class="form-group">
					<label for="pret_new_pret_id">Selectionner un topo</label>
					<s:select class="form-control" name="pret.topoEmprunte.id" list="listTopo" listKey="id" listValue="nom" label="Selectionner un topo" emptyOption="false" requiredLabel="true" />
				</div>
			</s:if>
			<div class="form-group">
				<label for="pret_new_pret_dateDebut">Date début</label>
				<s:textfield class="form-control" name="pret.dateDebut" label="Date début" requiredLabel="true" />
			</div>
			<div class="form-group">
				<label for="pret_new_pret_dateFin">Date fin</label>
				<s:textfield class="form-control" name="pret.dateFin" label="Date fin" requiredLabel="true" />
			</div>
			<s:if test="#session.user">
				<s:hidden name="pret.emprunteur.id" value="%{session.user.id}"></s:hidden>
			</s:if>
			<s:submit class="btn btn-lg btn-primary btn-block" value="OK" />
		</s:form>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>