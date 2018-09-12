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
    <a href="<%=request.getContextPath()%>/addTopo/">Ajouter topo</a>
    
	<c:choose>
		<c:when test="${topo != null}">
			<h3>Liste des Topos</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Nb Pages</th>
						<th>Auteur</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="topo" items="${topo}">
						<tr>
							<td>${topo.id}</td>
							<td>${topo.nom}</td>
							<td>${topo.nbPages}</td>
							<td>${topo.auteur}</td>
							<td>${topo.date}</td>
							<td>
							<a href="<%=request.getContextPath()%>/topo/${topo.id}">Détail </a>&nbsp;
							<a href="<%=request.getContextPath()%>/update/topo/${topo.id}">Mettre à jour </a>&nbsp;
								<a href="<%=request.getContextPath()%>/delete/topo/${topo.id}"
								onclick="return confirm('Voulez-vous vraiment supprimer?')">Supprimer</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        Aucun Topo trouvé
        </c:otherwise>
	</c:choose>
</body>
</html>