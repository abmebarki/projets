<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>

<body><%@ include file="../_include/menu.jsp"%>
	<h2></h2>
<!-- <s:if test="%{msg!=''}">
        %{msg}
    </s:if>
 -->    
	<br />
	<br />
	
	<s:a action="site_new"><h4>Ajouter site</h4></s:a>
	<s:if test="%{listSite != null}">
	<h4>Liste des Sites</h4>
	<table cellpadding="5" cellspacing="5">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Nb Secteurs</th>
				<th>Ville</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="listSite">
				<tr>
					<td>
						<s:property value="id" />
					</td>
					<td>
						<s:property value="nom" />
					</td>
					<td>
						<s:property value="description" />
					</td>
					<td>
						<s:property value="nbSecteurs" />
					</td>
					<td>
						<s:property value="ville" />
					</td>
					<td>
						<s:a action="site_detail"><s:param name="id" value="id" />Détail</s:a>&nbsp;
						<s:a action="site_update"><s:param name="id" value="id" />Mettre à jour</s:a>&nbsp;
						<s:a action="site_delete" onclick="return confirm('Voulez-vous vraiment supprimer?')" ><s:param name="id" value="id" />Supprimer</s:a>&nbsp;
						
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	</s:if>
	<s:else>
		Aucun Site trouvé
	</s:else>
	<%@ include file="../_include/footer.jsp"%>
</body>
</html>