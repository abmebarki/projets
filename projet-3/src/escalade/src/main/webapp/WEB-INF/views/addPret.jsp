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
	<h3>Ajouter Prêt</h3>
	<form method="POST" name="add_pret"
		action="<%=request.getContextPath()%>/add/pret">
		Date début: <input name="dateDebut" value="${dateDebut}" type="text" /> 
		<br />
		<br /> 
		Date fin: <input name="dateFin" value="${dateFin}" type="text" />
		<br />
		<br /> 
		<input value="Ajouter Prêt" type="submit" />
	</form>
</body>
</html>