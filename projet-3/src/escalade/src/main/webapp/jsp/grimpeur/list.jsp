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
			<s:a action="grimpeur_new">Ajouter grimpeur</s:a>
		</p>
		<s:if test="%{listGrimpeur != null}">
			<div class="table-responsive-sm">
				<table class="table table-hover">
					<caption>Liste des grimpeurs</caption>
					<thead class="thead-light">
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Nom</th>
							<th scope="col">Email</th>
							<th scope="col">Role</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listGrimpeur">
							<tr>
								<td><s:property value="id" /></td>
								<td><s:property value="nom" /></td>
								<td><s:property value="email" /></td>
								<td><s:property value="role" /></td>
								<td><s:a action="grimpeur_detail">
										<s:param name="id" value="id" />Détail</s:a>&nbsp; <s:if test="#session.user">
										<s:if test="#session.user.role.value() == 'ADMIN'">
											<s:a action="grimpeur_update">
												<s:param name="id" value="id" />Mettre à jour</s:a>&nbsp;
						<s:a action="grimpeur_delete" onclick="return confirm('Voulez-vous vraiment supprimer?')">
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
		Aucun Grimpeur trouvé
	</s:else>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>