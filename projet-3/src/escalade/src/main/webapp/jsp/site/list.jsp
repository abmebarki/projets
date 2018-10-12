<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>

<body>
	<div class="container">
		<%@ include file="../_include/menu.jsp"%>
		<p>
			<s:a action="site_new">Ajouter site</s:a>
		</p>
		<s:form action="site_list">
			<p>Rechercher un site</p>
			<div class="form-group">
				<label for="site_ville">Ville</label>
				<s:textfield class="form-control" label="ville" name="site.ville" />
			</div>
			<div class="form-group">
				<label for="site_expositions">Expositions</label>
				<s:checkboxlist label="Expositions" list="expositiontList" name="site.expositions" value="site.expositions" />
			</div>
			<div class="form-group">
				<label for="site_tempsApproche">Temps d'approche max en Minutes</label>
				<s:textfield class="form-control" name="site.tempsApproche" label="Temps d'approche max en Minutes" />
			</div>
			<div class="form-group">
				<label for="site_saisons">Saisons</label>
				<s:checkboxlist label="Saisons" list="saisonList" name="site.saisons" value="site.saisons" />
			</div>
			<div class="form-group">
				<label for="site.secteurs[0]_type">Type</label>
				<s:select class="form-control" name="site.secteurs[0].type" list="typeList" label="Type" emptyOption="true" />
			</div>
			<div class="form-group">
				<label for="site.secteurs[0]_difficulte">Difficulté</label>
				<s:select class="form-control" name="site.secteurs[0].difficulte" list="difficulteList" label="Difficulté" emptyOption="true" />
			</div>
			<s:submit class="btn btn-lg btn-primary btn-block" value="OK" />
		</s:form>


		<s:if test="%{listSite != null}">
			<div class="table-responsive-sm">
				<table class="table table-hover">
					<caption>Liste des sites</caption>
					<thead class="thead-light">
						<tr>
							<th scope="col">Nom</th>
							<th scope="col">Description</th>
							<th scope="col">Temps d'approche</th>
							<th scope="col">Ville</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listSite">
							<tr>
								<td><s:property value="nom" /></td>
								<td><s:property value="description" /></td>
								<td><s:property value="tempsApproche" /></td>
								<td><s:property value="ville" /></td>
								<td><s:a action="site_detail">
										<s:param name="id" value="id" />Détail</s:a>&nbsp; <s:if test="#session.user">
										<s:if test="#session.user.role.value() == 'ADMIN'">
											<s:a action="site_update">
												<s:param name="id" value="id" />Mettre à jour</s:a>&nbsp; 
						 			<s:a action="site_delete" onclick="return confirm('Voulez-vous vraiment supprimer?')">
												<s:param name="id" value="id" />Supprimer</s:a>&nbsp;
								</s:if>
									</s:if></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</s:if>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>