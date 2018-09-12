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
	<h3>Mettre à jour  Site</h3>
	<form method="POST" name="update_site" action="<%=request.getContextPath()%>/update/site">
		<input hidden="hidden" name="id" value="${id}" type="text" /> 
		Nom: <input name="nom" value="${site.nom}" type="text" />
		<br />
		<br /> 
		Description: <input name="description" value="${site.description}" type="text" /> 
		<br /> 
		<br /> 
		Nb Secteurs: <input name="nbSecteurs" value="${site.nbSecteurs}" type="text" />
		<br />
		<br /> 
		Ville: <input name="ville" value="${site.ville}" type="text" />
		<br />
		<br /> 
		<input value="Mettre à jour  Site" type="submit" />
	</form>
</body>
</html>