<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title></title>
<body>
	<h2></h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
    <br />
    <br />
    <a href="<%=request.getContextPath()%>/addSite/">Ajouter site</a>
    
	<c:choose>
		<c:when test="${site != null}">
			<h3>Liste des Sites</h3>
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
					<c:forEach var="site" items="${site}">
						<tr>
							<td>${site.id}</td>
							<td>${site.nom}</td>
							<td>${site.description}</td>
							<td>${site.nbSecteurs}</td>
							<td>${site.ville}</td>
							<td>
							<a href="<%=request.getContextPath()%>/site/${site.id}">Détail </a>&nbsp;
							<a href="<%=request.getContextPath()%>/update/site/${site.id}">Mettre à jour </a>&nbsp;
							<a href="<%=request.getContextPath()%>/delete/site/${site.id}" onclick="return confirm('Voulez-vous vraiment supprimer?')">Supprimer</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        Aucun Site trouvé
        </c:otherwise>
	</c:choose>
</body>
</html>