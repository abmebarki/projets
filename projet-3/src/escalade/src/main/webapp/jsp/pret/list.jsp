<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>
<body><%@ include file="../_include/menu.jsp"%>
	<h2></h2>
<!--	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
-->    
    <br />
    <br />
    <s:a action="pret_new">Ajouter prêt de topo</s:a>
    
	<s:if test="%{listPret != null}">
			<h4>Liste des Prêts</h4>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>Topo Id</th>
						<th>Emprunteur Id</th>
						<th>Date début</th>
						<th>Date fin</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="listPret">
						<tr>
							<td><s:property value="pret.emprunteur.id" /></td>
							<td><s:property value="pret.topoEmprunte.id" /></td>
							<td><s:date name="dateDebut" /></td>
							<td><s:date name="dateFin" /></td>
							<td>
							<s:a action="pret_detail"><s:param name="id" value="id" />Détail</s:a>&nbsp;
							<s:a action="pret_update"><s:param name="id" value="id" />Mettre à jour</s:a>&nbsp;
							<s:a action="pret_delete" onclick="return confirm('Voulez-vous vraiment supprimer?')" ><s:param name="id" value="id" />Supprimer</s:a>&nbsp;
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:if>
      <s:else>
		Aucun Prêt trouvé
	</s:else>
</body>
</html>