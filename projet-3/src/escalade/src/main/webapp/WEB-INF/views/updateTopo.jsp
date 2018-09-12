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
	<h3>Mettre à jour  Topo</h3>
	<form method="POST" name="update_topo" action="<%=request.getContextPath()%>/update/topo">
		<input hidden="hidden" name="id" value="${id}" type="text" /> 
		Nom: <input name="nom" value="${topo.nom}" type="text" />
		<br />
		<br /> 
		Auteur: <input name="auteur" value="${topo.auteur}" type="text" /> 
		<br /> 
		<br /> 
		Nb Pages: <input name="nbPages" value="${topo.nbPages}" type="text" />
		<br />
		<br /> 
		Date: <input name="date" value="${topo.date}" type="text" />
		<br />
		<br /> 
		<input value="Mettre à jour  Topo" type="submit" />
	</form>
</body>
</html>