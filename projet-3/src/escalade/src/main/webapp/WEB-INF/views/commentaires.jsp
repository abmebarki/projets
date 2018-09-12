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
    <a href="<%=request.getContextPath()%>/addCommentaire/">Ajouter commentaire</a>
    
	<c:choose>
		<c:when test="${commentaire != null}">
			<h3>Liste des Commentaires</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Objet</th>
						<th>Contenu</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="commentaire" items="${commentaire}">
						<tr>
							<td>${commentaire.id}</td>
							<td>${commentaire.objet}</td>
							<td>${commentaire.contenu}</td>
							<td>${commentaire.date}</td>
							<td><a
								href="<%=request.getContextPath()%>/update/commentaire/${commentaire.id}">Mettre à jour </a>&nbsp;
								<a href="<%=request.getContextPath()%>/delete/commentaire/${commentaire.id}"
								onclick="return confirm('Voulez-vous vraiment supprimer?')">Supprimer</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        Aucun Commentaire trouvé
        </c:otherwise>
	</c:choose>
</body>
</html>