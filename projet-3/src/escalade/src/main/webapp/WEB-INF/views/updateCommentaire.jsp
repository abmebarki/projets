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
	<h3>Mettre à jour  Commentaire</h3>
	<form method="POST" name="update_commentaire" action="<%=request.getContextPath()%>/update/commentaire">
		<input hidden="hidden" name="id" value="${id}" type="text" /> 
		Objet: <input name="nom" value="${commentaire.objet}" type="text" />
		<br />
		<br /> 
		Contenu: <input name="description" value="${commentaire.contenu}" type="text" /> 
		<br /> 
		<br /> 
		Date: <input name="nbSecteurs" value="${commentaire.date}" type="text" />
		<br />
		<br /> 
		<input value="Mettre à jour  Commentaire" type="submit" />
	</form>
</body>
</html>