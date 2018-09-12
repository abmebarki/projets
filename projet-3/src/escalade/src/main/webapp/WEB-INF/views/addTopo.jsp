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
	<h3>Ajouter Topo</h3>
	<form method="POST" name="add_topo"
		action="<%=request.getContextPath()%>/add/topo">
		Nom: <input name="nom" value="${nom}" type="text" /> 
		<br />
		<br /> 
		Auteur: <input name="auteur" value="${auteur}" type="text" />
		<br />
		<br /> 
		Nb pages: <input name="nbPages" value="${nbPages}" type="text" />
		<br /> 
		<br /> 
		Date: <input name="date" value="${date}" type="text" />
		<br /> 
		<br /> 
		<input value="Ajouter Topo" type="submit" />
	</form>
</body>
</html>