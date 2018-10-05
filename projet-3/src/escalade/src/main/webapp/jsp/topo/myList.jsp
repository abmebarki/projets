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
    <s:a action="topo_new">Ajouter topo</s:a>
	<s:if test="%{listTopo != null}">
			<h4>Liste des Topos</h4>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Nb Pages</th>
						<th>Auteur</th>
						<th>Date</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="listTopo">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="nom" /></td>
							<td><s:property value="nbPages" /></td>
							<td><s:property value="auteur" /></td>
							<td><s:date name="date" /></td>
							
							
						<td>
						<s:a action="topo_detail"><s:param name="id" value="id" />Détail</s:a>&nbsp;
						<s:if test="#session.user">
						<s:if test="#session.user.role == 'USER'">
							<s:a action="topo_update"><s:param name="id" value="id" />Mettre à jour</s:a>&nbsp;
							<s:a action="topo_delete" onclick="return confirm('Voulez-vous vraiment supprimer?')" ><s:param name="id" value="id" />&nbsp;<s:param name="proprietaireId" value="#session.user.id" />Supprimer</s:a>&nbsp;
						</s:if>
						</s:if>
						
					</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:if>
      <s:else>
		Aucun Topo trouvé
	</s:else>
</body>
</html>