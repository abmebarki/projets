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
	<h3>Ajouter Site</h3>
	<form method="POST" name="add_site"
		action="<%=request.getContextPath()%>/add/site">
		Nom: <input name="nom" value="${nom}" type="text" /> 
		<br />
		<br /> 
		Description: <input name="description" value="${description}" type="text" />
		<br />
		<br /> 
		Nb Secteurs: <input name="nbSecteurs" value="${nbSecteurs}" type="text" />
		<br /> 
		<br /> 
		Ville: <input name="ville" value="${ville}" type="text" />
		<br /> 
		<br /> 
		<input value="Ajouter Site" type="submit" />
	</form>
</body>
</html>