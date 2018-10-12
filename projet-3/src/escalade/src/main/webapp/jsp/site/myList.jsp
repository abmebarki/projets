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
										<s:if test="#session.user.role.value() == 'USER'">
											<s:a action="site_update">
												<s:param name="id" value="id" />Mettre à jour</s:a>&nbsp; 
						 			<s:a action="site_delete" onclick="return confirm('Voulez-vous vraiment supprimer?')">
												<s:param name="id" value="id" />&nbsp;<s:param name="createurId" value="#session.user.id" />Supprimer</s:a>&nbsp;
								</s:if>
									</s:if></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</s:if>
		<s:else>
		Aucun Site trouvé
		</s:else>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>