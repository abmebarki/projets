<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>
<body>
	<div class="container"><%@ include file="../_include/menu.jsp"%>
		<p>
			<s:a action="pret_new">Emprunter un topo</s:a>
		</p>
		<s:if test="%{listPret != null}">
			<div class="table-responsive-sm">
				<table class="table table-hover">
					<caption>Liste des prêts</caption>
					<thead class="thead-light">
						<tr>
							<th scope="col">Topo</th>
							<th scope="col">Emprunteur</th>
							<th scope="col">Date début</th>
							<th scope="col">Date fin</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listPret">
							<tr>
								<td><s:property value="topoEmprunte.nom" /></td>
								<td><s:property value="emprunteur.nom" /></td>
								<td><s:date name="dateDebut" /></td>
								<td><s:date name="dateFin" /></td>
								<td><s:a action="pret_detail">
										<s:param name="id" value="id" />Détail</s:a>&nbsp; <s:if test="#session.user">
										<s:if test="#session.user.role.value() == 'ADMIN'">
											<s:a action="pret_update">
												<s:param name="id" value="id" />Mettre à jour</s:a>&nbsp;
							<s:a action="pret_delete" onclick="return confirm('Voulez-vous vraiment supprimer?')">
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
		Aucun Prêt trouvé
	</s:else>
		<%@ include file="../_include/footer.jsp"%>
	</div>
</body>
</html>