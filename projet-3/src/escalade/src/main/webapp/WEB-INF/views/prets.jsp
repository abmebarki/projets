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
    <a href="<%=request.getContextPath()%>/addPret/">Ajouter Prêt</a>
    
	<c:choose>
		<c:when test="${pret != null}">
			<h3>Liste des Prêts</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>Date début</th>
						<th>Date fin</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pret" items="${pret}">
						<tr>
							<td>${pret.dateDebut}</td>
							<td>${pret.dateFin}</td>
							<td><a
								href="<%=request.getContextPath()%>/update/pret/${pret.id}">Mettre à jour </a>&nbsp;
								<a href="<%=request.getContextPath()%>/delete/pret/${pret.id}"
								onclick="return confirm('Voulez-vous vraiment supprimer?')">Supprimer</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        Aucun Prêt trouvé
        </c:otherwise>
	</c:choose>
</body>
</html>