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
		<s:form action="topo_new">
			<legend>Création d'un topo d'escalade</legend>
			<s:if test="%{site == null}">
				<s:if test="%{listSite != null}">
					<div class="form-group">
						<label for="topo_new_topo_descriptibles_id">Selectionner un site</label>&nbsp;
						<s:a action="site_new">
							<label>Ou créer un nouveau site</</label>
						</s:a>
						<s:select class="form-control" name="topo.descriptibles.id" multiple="true" list="listSite" listKey="id" listValue="nom" label="Selectionner un site" emptyOption="false" requiredLabel="true" required="true"/>
					</div>
				</s:if>
			</s:if>
			<s:else>
				<s:label>Site</s:label>
				<s:property value="%{site.nom}" />
				<s:hidden name="topo.descriptibles.id" value="%{site.id}"></s:hidden>
				<s:hidden name="site.id" value="%{site.id}"></s:hidden>
			</s:else>
			<div class="form-group">
				<label for="topo_new_topo_nom">Nom</label>
				<s:textfield class="form-control" name="topo.nom" label="Nom" requiredLabel="true" required="true"/>
			</div>
			<div class="form-group">
				<label for="topo_new_topo_nbPages">Nb Pages</label>
				<s:textfield class="form-control" name="topo.nbPages" label="Nb Pages" requiredLabel="true" required="true"/>
			</div>
			<div class="form-group">
				<label for="topo_new_topo_auteur">Auteur</label>
				<s:textfield class="form-control" name="topo.auteur" label="Auteur" requiredLabel="true" required="true"/>
			</div>
			<div class="form-group">
				<label for="topo_new_topo_date">Date de publication (AAAA-MM-JJ)</label>
				<s:textfield class="form-control" name="topo.date" label="Date" requiredLabel="true" required="true"/>
			</div>
			<s:if test="#session.user">
				<s:hidden name="topo.proprietaire.id" value="%{session.user.id}"></s:hidden>
			</s:if>
			<s:submit class="btn btn-lg btn-primary btn-block" value="OK" />
		</s:form>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>