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
	<h3>Ajouter Commentaire</h3>
	<form method="POST" name="add_commentaire"
		action="<%=request.getContextPath()%>/add/commentaire">
		Objet: <input name="objet" value="${objet}" type="text" /> 
		<br />
		<br /> 
		Contenu: <input name="contenu" value="${contenu}" type="text" />
		<br />
		<br /> 
		Date: <input name="date" value="${date}" type="text" />
		<br /> 
		<br /> 
		<input value="Ajouter Commentaire" type="submit" />
	</form>
</body>
</html>