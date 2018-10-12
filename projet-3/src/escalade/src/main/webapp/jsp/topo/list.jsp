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
			<s:a action="topo_new">Ajouter topo</s:a>
		</p>
		<s:if test="%{listTopo != null}">
			<div class="table-responsive-sm">
				<table class="table table-hover">
					<caption>Liste des topos</caption>
					<thead class="thead-light">
						<tr>
							<th scope="col">Nom</th>
							<th scope="col">Nb Pages</th>
							<th scope="col">Auteur</th>
							<th scope="col">Date</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listTopo">
							<tr>
								<td><s:property value="nom" /></td>
								<td><s:property value="nbPages" /></td>
								<td><s:property value="auteur" /></td>
								<td><s:date name="date" /></td>
								<td><s:a action="topo_detail">
										<s:param name="id" value="id" />Détail</s:a>&nbsp; <s:if test="#session.user">
										<s:if test="#session.user.role.value() == 'ADMIN'">
											<s:a action="topo_update">
												<s:param name="id" value="id" />Mettre à jour</s:a>&nbsp;
						<s:a action="topo_delete" onclick="return confirm('Voulez-vous vraiment supprimer?')">
												<s:param name="id" value="id" />Supprimer</s:a>&nbsp;
						</s:if>
									</s:if></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</s:if>
		<s:else>
		Aucun Topo trouvé
	</s:else>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>