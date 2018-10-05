<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>
<body><%@ include file="../_include/menu.jsp"%>
	<br />
	<br />
	<s:a action="site_new">Ajouter site</s:a>
	<h4>Liste des Sites</h4>
	<table cellpadding="5" cellspacing="5">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Exposition</th>
				<th>Temps d'approche</th>
				<th>Saisons</th>
				<th>Ville</th>
				<th>Action</th>
			</tr>
		</thead>
		<s:if test="%{listSite != null}">
			<tbody>
				<s:iterator value="listSite">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="nom" /></td>
						<td><s:property value="description" /></td>

						<td><s:property value="exposition" /></td>

						<td><s:property value="tempsApproche" /></td>

						<td><s:property value="saison" /></td>
						<td><s:property value="ville" /></td>
						<td>
							<s:a action="site_detail"><s:param name="id" value="id" />Détail</s:a>&nbsp;
							<s:if test="#session.user">
								<s:if test="#session.user.role == 'USER'">
									<s:a action="site_update"><s:param name="id" value="id" />Mettre à jour</s:a>&nbsp; 
						 			<s:a action="site_delete" onclick="return confirm('Voulez-vous vraiment supprimer?')"><s:param name="id" value="id" />&nbsp;<s:param name="createurId" value="#session.user.id" />Supprimer</s:a>&nbsp;
								</s:if>
							</s:if>
					 	</td>
					</tr>
				</s:iterator>
			</tbody>
		</s:if>
		<s:else>
		Aucun Site trouvé
	</s:else>
	</table>

	<%@ include file="../_include/footer.jsp"%>
</body>
</html>